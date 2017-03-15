/*It should take a large string array, randomly distribute it into 5 evenly sized string arrays, 
then for each of the folds, take all the other folds and combine them into a big one,
 run train on the big one and test the little one. 
*/


/*
	Citation: http://stackoverflow.com/questions/3316674/how-to-shuffle-characters-in-a-string
*/
public static String shuffle(String s)
{
  List<String> letters = Arrays.asList(s.split(""));
  Collections.shuffle(letters);
  String shuffled = "";
  for (String letter : letters) {
    shuffled += letter;
  }
  return shuffled;
}

public void foldCrossValidation(String data){
  int dataSize = length(data);
  int foldSize = ceiling(dataSize / 5);
  String f1,f2,f3,f4,f5, datacopy;

  // shuffle data so we can randomly assign it to fold
  data = shuffle(data);

  // randomly distribute data into 5 evenly sized string arrays  
  f1 = data.substring(0,foldSize);
  f2 = data.substring(foldSize,2*foldSize);
  f3 = data.substring(2*foldSize,3*foldSize);
  f4 = data.substring(3*foldSize,4*foldSize);
  f5 = data.substring(4*foldSize,dataSize);

	/*
		for each of the folds, take all the other folds and combine them into a big one,
		run train on the big one and test the little one. 
 */

	String bigFold1,bigFold2,bigFold3,bigFold4,bigFold5;

	//f1
	bigFold1 = substring(foldSize, dataSize);
	train(bigFold1);
	test(f1);

	//f2
	bigFold2 = substring(0, foldSize) + substring(2*foldSize,dataSize);
	train(bigFold2);
	test(f2);

	//f3
	bigFold3 = substring(0, 2*foldSize) + substring(3*foldSize,dataSize);
	train(bigFold3);
	test(f3);

	//f4
	bigFold4 = substring(0, 3*foldSize) + substring(4*foldSize,dataSize);
	train(bigFold4);
	test(f4);

	//f5
	bigFold5 = substring(0, 4*dataSize);
	train(bigFold5);
	test(f5);

	return;
}