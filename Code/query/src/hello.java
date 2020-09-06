public class hello {
    public static void main(String[] args) {
        hello a = new hello();
        String path = "D:\\bsbmtools-0.2\\dataset2.txt";
        seQuery seq = new seQuery(path);
        long startTime = System.currentTimeMillis();
        String query1 = "http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromRatingSite10/Review94160";
        String query2 = "http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/rating4";
        String[] result = seq.query(query1,query2);
        long stopTime = System.currentTimeMillis();
        long TotalTime = stopTime-startTime;
        System.out.println(TotalTime);
        for(int i=0;i<5;i++){
            System.out.println(result[i]);
        }


    }
}
