class Towerofhanoi{
    public static void main(String args[]){
        int src = 1;
        int help = 2;
        int des = 3;
        int step = 0;
        int disk = 3;

        System.out.println(Towerofhanoi.count(src,help,des,step,disk));
    }

    public static int count(int src , int help , int des , int step , int disk){
        if(disk == 1){
            step++;
            System.out.println("Move disk " + disk + " from " + src + " to " + des);
            return step;
        }
        step = count(src , des, help , step, disk-1);
        step++;
        System.out.println("Move disk " + disk + " from " + src + " to " + des);

        step = count(help,src,des,step,disk-1);

        return step;
    }
}