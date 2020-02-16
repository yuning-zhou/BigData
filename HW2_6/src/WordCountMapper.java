import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{


    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString().toLowerCase();

        //"hackathon, Dec, Chicago, Java";

        if (line.contains("hackathon")) {
            context.write(new Text("hackathon"), new IntWritable(1));
        } else {
            context.write(new Text("hackathon"), new IntWritable(0));
        }

        if (line.contains("dec")) {
            context.write(new Text("Dec"), new IntWritable(1));
        } else {
            context.write(new Text("Dec"), new IntWritable(0));
        }

        if (line.contains("chicago")) {
            context.write(new Text("Chicago"), new IntWritable(1));
        } else {
            context.write(new Text("Chicago"), new IntWritable(0));
        }

        if (line.contains("java")) {
            context.write(new Text("Java"), new IntWritable(1));
        } else {
            context.write(new Text("Java"), new IntWritable(0));
        }
    }


}
