/**
 *
 * @author Edmundo J Sanchez M
 */
public class AlgoritmoKnuthMorrisPratt {

        void igualarCadenaConKMP(String pat, String txt) {
            int m = pat.length();
            int n = txt.length();
            int lps[] = calcularFuncionPrefijo(pat);
            int j = 0; 
            int i = 0;
            for(i=0;i<n;i++){
                while(j>0&&pat.charAt(j)!=txt.charAt(i)){
                    j=lps[j-1];
                }
                if(pat.charAt(j)==txt.charAt(i)){
                    j=j+1;
                }
                if(j==m){
                    System.out.println("Ocurrencia de patron en: "+(i-m+1));
                    j= lps[j-1];
                }
            }
        }

        public int[] calcularFuncionPrefijo(String pat) {
            int m = pat.length();
            int pi [] = new int[m];
            pi[0] = 0; 
            int k = 0;
            for(int q=1;q<m;q++){
                while(k>0&&pat.charAt(k+1)!=pat.charAt(q)){
                    k = pi[k];
                }
                if(pat.charAt(k+1)==pat.charAt(q)){
                    k++;
                }
                pi[q]=1;
            }
            return pi;
        }

    }
