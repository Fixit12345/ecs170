public class FFNN {
	public static int InputNuerons = 15360; //128 * 120
	public static int HiddenNuerons = 20; //deviced arbitarilaly
	public static int OutputNuerons = 1;
	
	
	public int inputs[] = new int[InputNuerons];
	public int hiddens[] = new int[HiddenNuerons];
	public int Outputs[] = new int[OutputNuerons];
	
	public int weightsOutToHidden[] = new int[OutputNuerons][HiddenNuerons];
	public int weightsHiddenToIn[] = new int[HiddenNuerons][InputNuerons];
	
	public double learningRate = 0.2;
	public double prediction = 0;
	public double outputError = 0;
	
	public FFNN(){}
	
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
					Outputs[i] = Outputs[i] + (weightsOutToHiddenn[i][j] * hiddens[j]);
				}
				//sigmoid value after all hiddens applied
				Outputs[i] = 1/ (1 + Math.exp(-Outputs[i]));
			}
			
		}
	
	//use calculated error to appoint proportioal error and update weights accordingly
	public void backProp(){
			double hiddenError;
			
			//total output layer error
			for(int ole = 0; ole < OutputNuerons; ole++){
				outputError = (prediction - Outputs[ole]) * ((Outputs[ole])*(1 - Outputs[ole]));
			}
			
			//total hidden layer error
			for(int hle = 0; hle < HiddenNuerons; hle++){
				hiddenError[hle] = 0;
				
				//add error of output nodes
				for(int ole = 0; ole < OutputNuerons; ole++){
					//weight error
					hiddenError[hle] += outputError  * weightsOutToHidden[ole][hle];
					//derive error
					hiddenError[hle] = hiddenError[hle]] * (hiddenError[hle]*(1-hiddenError[hle]));
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
	
	public void computeErr(){}
	
	public void gradOuttoHidden(){}
	
	public void gradHiddentoIn(){}
	
	public void updatWeights(){}
	
	public void train(){}
	
	public void test(){}

    public void hello(){
        System.out.println("Hello, World");
    }

}
