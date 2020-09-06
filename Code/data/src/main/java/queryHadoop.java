import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class queryHadoop{

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        //System.out.println("Run success");
        //conf.set("mapreduce.framework.name", "yarn");
        //conf.set("yarn.resourcemanager.hostname", "server1");
        //String query1 = "http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromRatingSite10/Review94160";
        //String query2 = "http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/rating4";
        //String query = query1+"||"+query2;
        //conf.set("query",query);
        Job job = Job.getInstance(conf,"query");
        job.setJarByClass(queryHadoop.class);
        job.setMapperClass(queryMapper.class);
        job.setReducerClass(queryReducer.class);
        //job.setCombinerClass(queryReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        //String inputPath = "/query/input";
        //String outputPath = "/query/output";
        //System.out.println("Run success");
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.submit();
        try {
            job.waitForCompletion(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}