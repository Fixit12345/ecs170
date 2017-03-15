import java.util.*;
import java.io.*;

public class FFNN {
	public static int InputNuerons = 15360; //128 * 120
	public static int HiddenNuerons = 20; //deviced arbitarilaly
	public static int OutputNuerons = 1;
	
	
	public double inputs[] = new double[InputNuerons];
	public double hiddens[] = new double[HiddenNuerons];
	public double outputs[] = new double[OutputNuerons];
	
	public double weightsOutToHidden[][] = new double[OutputNuerons][HiddenNuerons];
	public double weightsHiddenToIn[][] = new double[HiddenNuerons][InputNuerons];
	
	public double learningRate = 0.3;
	public double prediction = 0;
	public double outputError = 0;
	
	public FFNN(){
		randomWeights();
	}
	
	//returns prediction based on input to the network
	public void forwardProp(){
			//activate Input to Hidden Layer
			for (int i = 0; i < HiddenNuerons; i++){
				//for each input hidden node pair, add value
				for (int j = 0; j < InputNuerons; j++){
					hiddens[i] = hiddens[i] + (weightsHiddenToIn[i][j] * inputs[j]);
				}
				//sigmoid value after all inputs applied
				hiddens[i] = 1/ (1 + Math.exp(-hiddens[i]));
			}
			
			//activate Hidden to Output Layer
			for (int i = 0; i < OutputNuerons; i++){
				//for each hidden ouput node pair, add value
				for (int j = 0; j < HiddenNuerons; j++){
					outputs[i] = outputs[i] + (weightsOutToHidden[i][j] * hiddens[j]);
				}
				//sigmoid value after all hiddens applied
				outputs[i] = 1/ (1 + Math.exp(-outputs[i]));
			}
			
		}
	
	//use calculated error to appoint proportioal error and update weights accordingly
	public void backProp(){
			double hiddenError[] = new double[HiddenNuerons];
			
			//total output layer error
			for(int ole = 0; ole < OutputNuerons; ole++){
				outputError = prediction - outputs[ole];// * ((outputs[ole])*(1 - outputs[ole]));
			}
			
			
			//total hidden layer error
			for(int hle = 0; hle < HiddenNuerons; hle++){
				hiddenError[hle] = 0;
				
				//add error inheritted output nodes
				for(int ole = 0; ole < OutputNuerons; ole++){
					//weight error
					hiddenError[hle] = hiddenError[hle] + outputError  * weightsOutToHidden[ole][hle];
					//derive error
					hiddenError[hle] = hiddenError[hle] * (hiddenError[hle]*(1-hiddenError[hle]));
				}
			}
		
			//adjust the weights from the hidden to output layer
			for(int ole = 0; ole < OutputNuerons; ole++){
				for(int hle = 0; hle < HiddenNuerons; hle++){
					weightsOutToHidden[ole][hle] = weightsOutToHidden[ole][hle] + learningRate * 
						outputError * hiddenError[hle];
				}
			}
		
			//adjust the weights from the input to hidden layer
			for(int hle = 0; hle < HiddenNuerons; hle++){
				for(int ile = 0; ile < InputNuerons; ile++){
					weightsHiddenToIn[hle][ile] = weightsHiddenToIn[hle][ile] + learningRate * 
						hiddenError[hle] * inputs[ile];
				}
			}
			
		}
	
	//randomize the weights to initalize the network
	public void randomWeights(){
		//initialzie the weights of the output neurons and hidden neurons
		for(int i = 0; i < OutputNuerons; i++){
			for(int j = 0; j < HiddenNuerons; j++){
				weightsOutToHidden[i][j] = Math.random();
			}
		}
		
		//initialzie the weights of the hidden neurons and input neurons
		for(int i = 0; i < HiddenNuerons; i++){
			for(int j = 0; j < InputNuerons; j++){
				weightsHiddenToIn[i][j] = Math.random();
			}
		}
	}
	
	//trains network based on data given
	public void train(String dir){
		
		String[] dirFiles;
        File myDir = null;
        File tFile = null;
        
        myDir = new File(dir);
        dirFiles = myDir.list();
        
        if(dir.equals("Female")){
			prediction = 1;
		}
		
		if(dir.equals("Male")){
			prediction = 0;
		}
        
		//for every filename in our training data
		//we should scan the data into our input nodes
		//run forwardProp
		//then backProp
		
		
		for(String dFile: dirFiles){
			openFile(dir + "/" + dFile);
			
			Arrays.fill(hiddens, 0.0);
			
			forwardProp();
			backProp();
			
			//printPerformance();
		}
	}
	
	//test network prediction performance agaisnt given data
	public void test(String dir){
		
		String[] dirFiles;
        File myDir = null;
        File tFile = null;
        
        myDir = new File(dir);
        dirFiles = myDir.list();
        
        
		//for every filename in our training data
		//we should scan the data into our input nodes
		//run forwardProp
		//then backProp
		
		
		for(String dFile: dirFiles){
			openFile(dir + "/" + dFile);
			
			Arrays.fill(hiddens, 0.0);
			
			forwardProp();
			
			if(outputs[0] > .5){
				System.out.println(dFile + " FEMALE " + outputs[0]);
			} else {
				System.out.println(dFile + " MALE " + outputs[0]);
			}
			
			//System.out.println(dFile);
			//System.out.println(outputs[0]);
			
			//printPerformance();
		}
	}
	
	public void openFile(String filename) {
		//System.out.println(filename);
		try{
		Scanner scanner = new Scanner(new File(filename));
		int i = 0;
		while(scanner.hasNextInt())
		{
			inputs[i++] = scanner.nextInt();
		}
		
		} catch (FileNotFoundException nf) {
            System.err.println("FileNotFound: " + nf.getMessage());
            System.exit(6);
		}
	}
		
    public void hello(){
        System.out.println("Hello, World");
    }
    
    public void printPerformance(){
		//System.out.println("The correct output should be: " + prediction);
		//System.out.println("The networks seems to think this is the asnswer: " + outputs[0]);
		//System.out.println("The error of the network seems to be: " + outputError);
	}

}
