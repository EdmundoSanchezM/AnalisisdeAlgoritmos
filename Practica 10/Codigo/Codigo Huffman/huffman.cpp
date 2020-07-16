#include <queue>
#include <map>
#include <fstream>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define null 0
#define foreach(it, c) for (__typeof((c).begin()) it = (c).begin(); it != (c).end(); ++it)
class Huffman
{
private:
    struct node
    {
        node *fe, *fd, *pare;
        char c;
        double f;
        node(node *fe, node *fd, char c, double f) : fe(fe), fd(fd), pare(null), c(c), f(f)
        {
            if (fe != NULL)
                fe->pare = this;
            if (fd != NULL)
                fd->pare = this;
        }
        ~node()
        {
            delete fe;
            delete fd;
        }
    };
    node *arrel;
    map<char, node *> fulles;
    struct comparador
    {
        bool operator()(node *p, node *q)
        {

            return p->f > q->f;
        }
    };
    string codificar(node *p)
    {

        if (p->pare == null)
        {
            return "";
        }
        else
        {
            if (p->pare->fe == p)
            {
                return codificar(p->pare) + '0';
            }
            else
            {
                return codificar(p->pare) + '1';
            }
        }
    }

public:
    ~Huffman()
    {
        delete arrel;
    }
    Huffman(map<char, double> &F)
    {
        priority_queue<node *, vector<node *>, comparador> CP;
        foreach (it, F)
        {
            node *p = new node(null, null,
                               it->first, it->second);
            CP.push(p);
            fulles[it->first] = p;
        }
        while (CP.size() != 1)
        {
            node *p = CP.top();
            CP.pop();
            node *q = CP.top();
            CP.pop();
            CP.push(new node(p, q, ' ', p->f + q->f));
        }
        arrel = CP.top();
    }
    string decodificar(string s)
    {
        cout << " LEN(s) " << s.size() << " " << s << endl;
        string r;
        node *p = arrel;
        unsigned i = 0;
        while (i <= s.length())
        {

            if (p->c != ' ')
            {
                r += p->c;
                p = arrel;
            }
            else
            {
                p = s[i++] == '0' ? p->fe : p->fd;
            }
        }
        return r;
    }
    string codificar(string s)
    {
        string r;
        for (unsigned i = 0; i < s.size(); ++i)
        {
            r += codificar(fulles[s[i]]);
        }
        return r;
    }
};

string LecuturaArchivo()
{
    string lineaF = "";
    string linea;
    ifstream archivo("Secuencia Genomica 1.txt");
    if (archivo.is_open())
    {
        while (getline(archivo, linea))
        {
            lineaF += linea;
        }
        archivo.close();
    }

    else
        cout << "No de abrio el archivo";
    return lineaF;
}

void EscrituraArchivo(string codificacion)
{
    ofstream Archivo;
    Archivo.open("Codificacion Secuencia Genomica 1 C++.txt");
    Archivo << codificacion;
    Archivo.close();
}

void CompararArchivos()
{
    string linea1;
    ifstream archivo("Codificacion Secuencia Genomica 1 Java.txt");
    string linea2;
    ifstream archivo2("Codificacion Secuencia Genomica 1 C++.txt");
    bool iguales = true;
    bool archivoa = true;
    if(linea1.compare(linea2)){
    	
    }
    if (archivo.is_open() && archivo2.is_open())
    {
        while (getline(archivo, linea1) && getline(archivo2, linea2) && iguales)
        {
            if (linea1.compare(linea2))
            {
                iguales = false;
            }
        }
        archivo.close();
        archivo2.close();
    }
    else
    {
        cout << "No se pudo abrir un archivo";
        archivoa = false;
    }

    if (iguales && archivoa)
    {
        cout << "Los ficheros son iguales" << endl;
    }
    if (archivoa && !iguales)
    {
        cout << "Los ficheros son diferentes" << endl;
    }
}
map<char, double> Frecuencia(string cadena)
{
    int n = cadena.length();
    char Arraycadena[n + 1];
    char caracter;
    strcpy(Arraycadena, cadena.c_str());
    map<char, double> F;
    for (int i = 0; i < sizeof(Arraycadena); i++)
    {
        caracter = Arraycadena[i];
        F[caracter] = 0.0;
        for (int j = i; j < sizeof(Arraycadena); j++)
        {
            if (Arraycadena[j] == caracter)
            {
                double contador = F[caracter] + 1;
                F[caracter] = contador;
                Arraycadena[j] = ' ';
            }
        }
    }
    F.erase('\0');
    F.erase(' ');
    foreach (it, F)
    {
        double Frecuencia = F[it->first] / sizeof(Arraycadena);
        F[it->first] = Frecuencia;
        cout << "Caracter " << it->first << " Frecuencia: " << F[it->first] << endl;
    }
    return F;
}
int main(int argc, char *argv[])
{
    string Archivo = "Secuencia Genomica 1";
    string cadena = LecuturaArchivo();
    map<char, double> F = Frecuencia(cadena);
    Huffman h(F);
    cout << " CADENA : " << cadena << endl;
    string codificado = h.codificar(cadena);
    cout << " CODIFICADO : " << codificado << endl;
    string decodificado = h.decodificar(codificado);
    cout << " DECODIFICADO: " << decodificado << endl;
    EscrituraArchivo(codificado);
    CompararArchivos();
    return 0;
}
