package Strings;

public class shortestPath {
    public static void main(String[] args) {
        String str = "WNEENESENNN";
        int x =0 , y = 0;
        double dist =0;
        for(int i = 0; i < str.length(); i++){
            switch(str.charAt(i)){
                case 'N': y++;
                    break;
                case 'S': y--;
                    break;
                case 'W': x--;
                    break;
                case 'E': x++;
                    break;

            }

        }
        dist = Math.hypot(x , y);
        System.out.print(dist);

    }
}
