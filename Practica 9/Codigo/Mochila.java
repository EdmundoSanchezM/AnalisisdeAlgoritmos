import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author sdelaot
 */
public class Mochila {

    private LinkedList<ObjetoDeMochila> objetos;

    public Mochila() {
        objetos = new LinkedList<>();
    }

    /**
     * Solucion y maximo beneficio alcanzable con los objetos 0,..,i-1, teniendo
     * un peso m disponible en la mochila (estructurado), genera un
     * ObjetoDeMochila y se introduce el que si me brinda mejor beneficio
     * (recursiva)
     *
     * @param i numero total de objetos
     * @param M peso maximo de la mochila
     * @param p arreglo de pesos de los objetos
     * @param b arreglo de beneficios de cada objeto
     * @return devuelve el peso maximo de que no se introduce el objeto
     */
    public int insertarObjetosEnMochila(int i, int M, int[] p, int[] b) {
        int maxBNO;
        int maxBSI;
// base de la recurrencia: 0 objetos
        if (i == 0) {
            return 0;
        }
// opcion 1: el objeto i -1 NO se introduce
        maxBNO = insertarObjetosEnMochila(i - 1, M, p, b);
// opcion 2: el objeto i -1 SI se introduce
        if (p[i - 1] <= M) {
            maxBSI = insertarObjetosEnMochila(i - 1, M - p[i - 1], p, b);
            if (b[i - 1] + maxBSI > maxBNO) {
                addObjeto(new ObjetoDeMochila(p[i - 1], b[i - 1]));
                return b[i - 1] + maxBSI;
            }
        }
        return maxBNO;
    }

    public int insertarObjetosEnMochila(int i, int M, ObjetoDeMochila[] objetos) {
        int maxBNO;
        int maxBSI;

        if (i == 0) {
            return 0;
        }
        maxBNO = insertarObjetosEnMochila(i - 1, M, objetos);
        if (objetos[i - 1].getPeso() <= M) {
            maxBSI = insertarObjetosEnMochila(i - 1, M - objetos[i - 1].getPeso(),
                    objetos);
            if (objetos[i - 1].getBeneficio() + maxBSI > maxBNO) {
                addObjeto(objetos[i - 1]);
                return objetos[i - 1].getBeneficio() + maxBSI;
            }
        }
        return maxBNO;
    }

    public int insertarObjetosEnMochilaPD(int p[], int b[], int M) {
        int n = p.length;
        int t[][] = new int[n + 1][M + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int m = 0; m < M + 1; m++) {
                t[i][m] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int m = 1; m < M + 1; m++) {
                if (p[i - 1] <= m && b[i - 1] + t[i - 1][m - p[i - 1]] > t[i - 1][m]) {
                    t[i][m] = b[i - 1] + t[i - 1][m - p[i - 1]];
                } else {
                    t[i][m] = t[i - 1][m];
                }
            }
        }
        return t[n][M];
    }

    public int insertarObjetosEnMochilaPD(int M, ObjetoDeMochila[] objetos) {
        int n = objetos.length;
        int t[][] = new int[n + 1][M + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int m = 0; m < M + 1; m++) {
                t[i][m] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int m = 1; m < M + 1; m++) {
                if (objetos[i - 1].getPeso() <= m && objetos[i - 1].getBeneficio() + t[i - 1][m - objetos[i - 1].getPeso()] > t[i - 1][m]) {
                    t[i][m] = objetos[i - 1].getBeneficio() + t[i - 1][m - objetos[i - 1].getPeso()];
                } else {
                    t[i][m] = t[i - 1][m];
                }
            }
        }
        return t[n][M];
    }

    public int insertarObjetosEnMochilaPD2(int[] p, int[] b, int M) {
        int n = p.length;
        int ant[] = new int[M + 1];
        int act[] = new int[M + 1];
        for (int i = 0; i < M + 1; i++) {
            ant[i] = 0;
            act[i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int m = 1; m < M + 1; m++) {
                if (p[i - 1] <= m && (b[i - 1] + ant[m - p[i - 1]] > ant[m])) {
                    act[m] = b[i - 1] + ant[m - p[i - 1]];
                } else {
                    act[m] = ant[m];
                }
            }
            ant = act.clone();
        }
        return act[M];
    }

    public int insertarObjetosEnMochilaPD2(int M, ObjetoDeMochila[] objetos) {
        int n = objetos.length;
        int ant[] = new int[M + 1];
        int act[] = new int[M + 1];
        for (int i = 0; i < M + 1; i++) {
            ant[i] = 0;
            act[i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int m = 1; m < M + 1; m++) {
                if (objetos[i - 1].getPeso() <= m && (objetos[i - 1].getBeneficio() + ant[m - objetos[i - 1].getPeso()] > ant[m])) {
                    act[m] = objetos[i - 1].getBeneficio() + ant[m - objetos[i - 1].getPeso()];
                } else {
                    act[m] = ant[m];
                }
            }
            ant = act.clone();
        }
        return act[M];
    }

    public int insertarObjetosEnMochilaPD3(int[] p, int[] b, int M) {
        int n = p.length;
        int ant[] = new int[M + 1];
        int act[] = new int[M + 1];
        int d[][] = new int[n + 1][M + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int m = 0; m < M + 1; m++) {
                d[i][m] = 0;
            }
        }
        for (int i = 0; i < M + 1; i++) {
            ant[i] = 0;
            act[i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int m = 1; m < M + 1; m++) {
                if (p[i - 1] <= m && (b[i - 1] + ant[m - p[i - 1]] > ant[m])) {
                    act[m] = b[i - 1] + ant[m - p[i - 1]];
                    d[i][m] = 1;
                } else {
                    act[m] = ant[m];
                    d[i][m] = 0;
                }
            }
            ant = act.clone();
        }
        int[] x = new int[n];
        int m = M;
        for (int i = n; i > 0; i -= 1) {
            int[] xTemp = new int[n];
            for (int j = 0; j < n - 1; j++) {
                xTemp[j + 1] = x[j];
            }
            x = xTemp.clone();
            x[0] = d[i][m];
            if (d[i][m] == 1) {
                m = m - p[i - 1];
            }
        }
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                System.out.print("([" + x[j] + ",");
            } else if (j + 1 == n) {
                System.out.print(x[j] + "], ");
            } else {
                System.out.print(x[j] + ",");
            }
        }
        return act[M];
    }

    public int insertarObjetosEnMochilaPD3(int M, ObjetoDeMochila[] objetos) {
        int n = objetos.length;
        int ant[] = new int[M + 1];
        int act[] = new int[M + 1];
        int d[][] = new int[n + 1][M + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int m = 0; m < M + 1; m++) {
                d[i][m] = 0;
            }
        }
        for (int i = 0; i < M + 1; i++) {
            ant[i] = 0;
            act[i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int m = 1; m < M + 1; m++) {
                if (objetos[i - 1].getPeso() <= m && (objetos[i - 1].getBeneficio() + ant[m - objetos[i - 1].getPeso()] > ant[m])) {
                    act[m] = objetos[i - 1].getBeneficio() + ant[m - objetos[i - 1].getPeso()];
                    d[i][m] = 1;
                } else {
                    act[m] = ant[m];
                    d[i][m] = 0;
                }
            }
            ant = act.clone();
        }
        int[] x = new int[n];
        int m = M;
        for (int i = n; i > 0; i -= 1) {
            int[] xTemp = new int[n];
            for (int j = 0; j < n - 1; j++) {
                xTemp[j + 1] = x[j];
            }
            x = xTemp.clone();
            x[0] = d[i][m];
            if (d[i][m] == 1) {
                m = m - objetos[i - 1].getPeso();
            }
        }
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                System.out.print("([" + x[j] + ",");
            } else if (j + 1 == n) {
                System.out.print(x[j] + "], ");
            } else {
                System.out.print(x[j] + ",");
            }
        }
        return act[M];
    }

    public String CrearStringSolucion(ArrayList<Integer> solucion) {
        String imparreglo = "[";
        int n = solucion.size();
        for (int i = 0; i < n; i++) {
            if (i + 1 == n) {
                imparreglo += solucion.get(i) + "]";
            } else {
                imparreglo += solucion.get(i) + ",";
            }
        }
        return imparreglo;
    }

    public DatosMochila insertarObjetosEnMochilaPD4(int[] p, int[] b, int M) {
        int n = p.length;
        ArrayList<DatosMochila> ant = new ArrayList<DatosMochila>();
        ArrayList<Integer> Arrayvacio = new ArrayList<Integer>();
        for (int i = 0; i < M + 1; i++) {
            ant.add(new DatosMochila(0, Arrayvacio));
        }
        for (int i = 1; i < n + 1; i++) {
            ArrayList<Integer> ArraysolucionTemp = new ArrayList<Integer>();
            ArrayList<DatosMochila> act = new ArrayList<DatosMochila>();
            act.add(new DatosMochila(0, Arrayvacio));
            for (int m = 1; m < M + 1; m++) {
                if (p[i - 1] <= m && b[i - 1] + ant.get(m - p[i - 1]).getMaximoBeneficio() > ant.get(m).getMaximoBeneficio()) {
                    ArraysolucionTemp = (ArrayList<Integer>) ant.get(m - p[i - 1]).getSolucion().clone();
                    ArraysolucionTemp.add(1);
                    act.add(new DatosMochila(b[i - 1] + ant.get(m - p[i - 1]).getMaximoBeneficio(), ArraysolucionTemp));
                } else {
                    ArraysolucionTemp = (ArrayList<Integer>) ant.get(m).getSolucion().clone();
                    ArraysolucionTemp.add(0);
                    act.add(new DatosMochila(ant.get(m).getMaximoBeneficio(), ArraysolucionTemp));
                }
            }
            ant = (ArrayList<DatosMochila>) act.clone();
        }
        if (ant.get(M).Solucion.size() < n) {
            ant.get(M).Solucion.add(0);
            for (int i = n - 1; i > 0; i--) {
                ant.get(M).Solucion.set(i, ant.get(M).Solucion.get(i - 1));
            }
            ant.get(M).Solucion.set(0, 0);
        }
        return ant.get(M);
    }

    public DatosMochila insertarObjetosEnMochilaPD4(int M, ObjetoDeMochila[] objetos) {
        int n = objetos.length;
        ArrayList<DatosMochila> ant = new ArrayList<DatosMochila>();
        ArrayList<Integer> Arrayvacio = new ArrayList<Integer>();
        for (int i = 0; i < M + 1; i++) {
            ant.add(new DatosMochila(0, Arrayvacio));
        }
        for (int i = 1; i < n + 1; i++) {
            ArrayList<Integer> ArraysolucionTemp = new ArrayList<Integer>();
            ArrayList<DatosMochila> act = new ArrayList<DatosMochila>();
            act.add(new DatosMochila(0, Arrayvacio));
            for (int m = 1; m < M + 1; m++) {
                if (objetos[i - 1].getPeso() <= m && objetos[i - 1].getBeneficio() + ant.get(m - objetos[i - 1].getPeso()).getMaximoBeneficio() > ant.get(m).getMaximoBeneficio()) {
                    ArraysolucionTemp = (ArrayList<Integer>) ant.get(m - objetos[i - 1].getPeso()).getSolucion().clone();
                    ArraysolucionTemp.add(1);
                    act.add(new DatosMochila(objetos[i - 1].getBeneficio() + ant.get(m - objetos[i - 1].getPeso()).getMaximoBeneficio(), ArraysolucionTemp));
                } else {
                    ArraysolucionTemp = (ArrayList<Integer>) ant.get(m).getSolucion().clone();
                    ArraysolucionTemp.add(0);
                    act.add(new DatosMochila(ant.get(m).getMaximoBeneficio(), ArraysolucionTemp));
                }
            }
            ant = (ArrayList<DatosMochila>) act.clone();
        }
        if (ant.get(M).Solucion.size() < n) {
            ant.get(M).Solucion.add(0);
            for (int i = n - 1; i > 0; i--) {
                ant.get(M).Solucion.set(i, ant.get(M).Solucion.get(i - 1));
            }
            ant.get(M).Solucion.set(0, 0);
        }
        return ant.get(M);
    }

    /**
     * Devuelve los objetos contenidos en la mochila
     *
     * @return devuelve la lista de objetos dentro de la mochila
     */
    public LinkedList<ObjetoDeMochila> getObjetos() {
        return objetos;
    }

    private void addObjeto(ObjetoDeMochila objetoDeMochila) {
        objetos.add(objetoDeMochila);
    }
}
