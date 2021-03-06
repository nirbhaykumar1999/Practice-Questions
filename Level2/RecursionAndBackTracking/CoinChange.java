import java.io.BufferedReader;
import java.io.InputStreamReader;

class CoinChangeComb1 {
    
    public static void combinations(int cb, int tb, int ssf, int ts, String asf){
      
        if(cb > tb) {
            if(ssf == ts) {
                System.out.println(asf);
            }
            return;
        } 
        
        combinations(cb+1,tb,ssf+1,ts,asf + "i");
        combinations(cb+1,tb,ssf,ts,asf + "-");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }


}

class CoinChangeComb2 {
    
    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        
        if(i == coins.length) {
            if(amtsf == tamt) {
                System.out.println(asf + ".");
            }
            return;
        }
        
        // for(int j = tamt/coins[i]; j >= 1; j--) {
        //     String part = "";
        //     for(int k = 0; k < j; k++) {
        //         part += coins[i] + "-";
        //     }
            
        //     coinChange(i+1,coins,amtsf+coins[i]*j,tamt,asf+part);
        // }
        
        if(amtsf + coins[i] <= tamt)
        coinChange(i,coins,amtsf+coins[i],tamt,asf+coins[i] + "-");
        coinChange(i+1,coins,amtsf,tamt,asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}

class CoinChangePerm1 {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used){
       
        if(amtsf == tamt) {
            System.out.println(asf+".");
        }
        
        for(int i = 0; i < coins.length; i++) {
            
            if(!used[i] && amtsf + coins[i] <= tamt) {
                used[i] = true;
                coinChange(coins,amtsf+coins[i],tamt,asf+coins[i] + "-",used);
                used[i] = false;
            }
        }
     }
     public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         int[] coins = new int[n];
         for (int i = 0; i < n; i++) {
             coins[i] = Integer.parseInt(br.readLine());
         }
         int amt = Integer.parseInt(br.readLine());
         boolean[] used = new boolean[coins.length];
         coinChange(coins, 0, amt, "", used);
     }
}

class CoinChangePerm2 {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
        if (amtsf > tamt) {
            return;
        } else if (amtsf == tamt) {
            System.out.println(asf + ".");
            return;
        }

        for (int j = 0; j < coins.length; j++) {
            coinChange(coins, amtsf + coins[j], tamt, asf + coins[j] + "-");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(coins, 0, amt, "");
    }
}