package com.berenice.helloHadoop;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class WordcountMapRreducev1 {
	// cle valeur entree et sortie -
	// test à la place de string car string est imutable
	//on a un ampper par fichier
	public static class MonMpapper extends MapReduceBase implements
			Mapper<LongWritable, Text, Text, IntWritable> {

		// on appelle le mapper pour traiter chaque ligen d'entrée
		@Override
		public void map(LongWritable noLigne, Text ligne,
				OutputCollector<Text, IntWritable> sortie, Reporter reporter)
				throws IOException {

			if (ligne != null) {
				sortie.collect(new Text(ligne.toString().trim()),
						new IntWritable(1));
			}
			// TODO Auto-generated method stub

		}

	}

	//on a 1 reducer par fichier
	public static class MonReducteur extends MapReduceBase implements
			Reducer<Text, IntWritable, Text, IntWritable> {

		@Override
		// ici valeurs d'entree
		public void reduce(Text mot, Iterator<IntWritable> decompte,
		// valeurs de sortie
				OutputCollector<Text, IntWritable> sortie, Reporter reporter)
				throws IOException {

			int sum = 0;
			while (decompte.hasNext()) {
				sum += decompte.next().get();
			}
			sortie.collect(new Text(mot), new IntWritable(sum));

			// TODO Auto-generated method stub

		}
	}

	public static void main(String[] args) throws IOException {
		JobConf conf = new JobConf(WordcountMapRreducev1.class);
		conf.setJobName("wordcount");

		// conf types de données entrée en sortie

		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);

		// je choisis le mapper adequat pour ce job

		conf.setMapperClass(MonMpapper.class);

		// je choisis le reducteur pour ce job

		conf.setReducerClass(MonReducteur.class);

		conf.setCombinerClass(MonReducteur.class);

		// config nom des reducteurs utilisés - simple ne standalone
		// 1 mapper et un reducteur

		conf.setNumReduceTasks(1);

		// je choisis le format du fichier d'entrée ex csv, ici un mot par
		// ligne input format, mot ligne par ligne

		conf.setInputFormat(TextInputFormat.class);
		// format des données de sortie
		conf.setOutputFormat(TextOutputFormat.class);

		// indiquer les données en entrée(fichier) et de dire où on met le
		// rresultat ET idem pour les données de sortie

		FileInputFormat.setInputPaths(conf, new Path(args[0]));

		FileOutputFormat.setOutputPath(conf, new Path(args[1]));

		// lancement du job - l'objet conf donne toutes les infos
		// nécessaires

		JobClient.runJob(conf);

	}

}
