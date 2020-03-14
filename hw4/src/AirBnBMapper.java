import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class AirBnBMapper extends Mapper<LongWritable, Text, Text, IntWritable>{


    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        if (key.get() == 0 && value.toString().contains("host_id"){
            return;
        }

        String[] line = value.toString().split(",");

        //"Bronx", "Brooklyn", "Manhattan", "Queens", "Staten Island";

        String hood;

        if (line.contains("Bronx")) {
            hood = line[find(line, "Bronx") + 1];
            context.write(new Text("Bronx " + hood), new IntWritable(1));
        } else if (line.contains("Brooklyn")) {
            hood = line[find(line, "Brooklyn") + 1];
            context.write(new Text("Brooklyn " + hood), new IntWritable(1));
        }else if (line.contains("Manhattan")) {
            hood = line[find(line, "Manhattan") + 1];
            context.write(new Text("Manhattan " + hood), new IntWritable(1));
        } else if (line.contains("Queens")) {
            hood = line[find(line, "Queens") + 1];
            context.write(new Text("Queens " + hood), new IntWritable(1));
        } else if (line.contains("Staten Island")) {
            hood = line[find(line, "Staten Island") + 1];
            context.write(new Text("Staten Island " + hood), new IntWritable(1));
        } else {
            context.write(new Text("BAD_RECORD"), new IntWritable(1));
        }
    }

    public int find(String[] arr, String key){
        int count = 0;
        for (String a : arr){
            if (a.equals(key)){
                return count;
            }
            count++;
        }
        return -1;
    }


}
