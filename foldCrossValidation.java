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

public void foldCossValidation(String data[]){
  int dataSize = length(data);
  int foldSize = ceiling(dataSize / 5);
  int lastfoldSize = dataSize - 4*foldSize;
  int j;

  char[] f1 = new char[foldSize];
  char[] f2 = new char[foldSize];
  char[] f3 = new char[foldSize];
  char[] f4 = new char[foldSize];
  char[] f5 = new char[lastfoldSize];

  // shuffle data so we can randomly assign it to fold
  shuffle(data);

  /*
  randomly distribute data into 5 evenly sized string arrays
  */

	for(j = 0; j < foldSize; j++){
		f1[j] = data[j];
	}

	for(j = foldSize; j < 2*foldSize; j++){
		f2[j] = data[j];
	}

	for(j = 2*foldSize; j < 3*foldSize; j++){
		f3[j] = data[j];
	}

	for(j = 3*foldSize; j < 4*foldSize; j++){
		f4[j] = data[j];
	}

	for(j = 4*foldSize; j < dataSize; j++){
		f5[j] = data[j];
	}

	/*

		for each of the folds, take all the other folds and combine them into a big one,
		run train on the big one and test the little one. 

 */


	//f1
	char[] bigFold1 = new char[foldSize*3 + lastfoldSize];
	train(bigFold1);
	test(f1);

	//f2
	char[] bigFold2 = new char[foldSize*3 + lastfoldSize];
	train(bigFold2);
	test(f2);

	//f3
	char[] bigFold3 = new char[foldSize*3 + lastfoldSize];
	train(bigFold3);
	test(f3);

	//f4
	char[] bigFold4 = new char[foldSize*3 + lastfoldSize];
	train(bigFold4);
	test(f4);

	//f5
	char[] bigFold5 = new char[foldSize*4];
	train(bigFold5);
	test(f5);

	return;
}