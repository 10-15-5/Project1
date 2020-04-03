import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Project
{
	public static void main( String[] args )
	{
		int choice;
		String menuOption = "";
		while ((menuOption != null) && (!(menuOption.equals("0"))))
		{
			menuOption = getMenuOption();
			if (menuOption != null)
			{
				choice = Integer.parseInt(menuOption);
				if (choice != 0)
				{
					switch(choice)
					{
						case 1: vowelContent();		                 break;
						case 2: ConsonantContent();	                 break;
						case 3: AnalyzeWordSentenceContent();		 break;
						case 4: rowsOnqwertyKeyboard();              break;
						case 5: determineLongestAndShortestWords();  break;
						case 6: Alternating();						 break;
						case 7: areWordsOrPhrasesAnagrams();         break;
						case 8: IsPalindrome();                      break;
					}
				}
			}
		}
	}
		public static String getMenuOption()
	{
		String menuOptions = "1 . Analyze vowel content. " +
		  "\n2 . Analyze Consonant content. " + 
		  "\n3 . Analyze word/sentence content" +
		  "\n4 . Rows on qwerty keyboard" +
		  "\n5 . Longest and shortest words" +
		  "\n6 . Alternating vowels and consonants" +
		  "\n7 . Is it an anagram?" +
		  "\n8 . Is it a Palindrome?" +
		  "\n0 . Exit. ";
		  
		  boolean validInput = false;
		  String selection = "", menuChoicePattern = "[0-8]{1}";
		  String errorMessage = "Invalid menu selection";
		  		 errorMessage += "\n\nValid options are 0 to 8 inclusive";
				 errorMessage += "\nSelect Ok to retry";	
		  		 
	 while (!(validInput))
	  	{
			selection = JOptionPane.showInputDialog(null, menuOptions,"Choose number of option you wish have executed",3); 
			  		
			if (selection == null || selection.matches(menuChoicePattern))
			  	validInput = true;
			else
				JOptionPane.showMessageDialog(null, errorMessage, "Error in user input", 2);
		}
			return selection;
			  				
		}
		
	    public static String getWordPhraseFromUser(String message, String title, String pattern)
    {
		boolean validInput = false;
		String userInput = "";
		
		String errorMessage = ("Invalid input. Please enter input useing alphabetic characters");		 
		while (!(validInput))
		{
			userInput = JOptionPane.showInputDialog(null, message, title, 3);
			
			if ((userInput == null) || (userInput.matches(pattern)))
			validInput = true;
			else
			JOptionPane.showMessageDialog(null, errorMessage, "Error in user input", 2);
		}
		return userInput;
	}
	///////Method 1////////
      public static void vowelContent()
	{	   		    
	  String vowels = "aeiou";
	  String[] Letters = vowels.split("");
	  String message = "Enter word or phrase:";
	  String title= "Vowel content";
	  String pattern = "([a-zA-Z]+)|(([a-zA-Z]+\\s[a-zA-Z]+)+)";
	  String userInput = getWordPhraseFromUser(message, title, pattern);
	  String copyInput = userInput;
      userInput = userInput.toLowerCase();    
      String[] inputLetters= userInput.split("");
      String aChar = "";
      boolean isPos = true, isVowel = true; 
      boolean isReversePos = true; 
      String result = "";
      int posVowel = -1;
      int reversePosVowel=Letters.length;
      int posNum = 0, aNum = -1;
      int vowelCount = 0;
      int freq=0;	        
	  for(int i = 0;i<vowels.length();i++)
	  {
	    aChar = vowels.substring(i,i+1);
	    if(userInput.indexOf(aChar)!=-1)	    	   
	      posNum++;	     
	  }              
      if (posNum ==0)       
	    result+= "String contains no vowels" + "\n";	  
      else if (posNum ==5)       
	    result+= "String contains all vowels in any order" + "\n";
           
      for(int i = 0;i<userInput.length();i++)
      {
        aChar = userInput.substring(i,i+1);
        if(vowels.indexOf(aChar)!=-1)      
          vowelCount++;
             
      }	
	  result+= "Vowel Count = " + vowelCount + "\n";  
	  if(posNum == 5)
	  {  
        for(int i=0; i<copyInput.length() && isPos == true;i++)//Checks if input is alphabetical
		{		
		  System.out.print(copyInput.charAt(i));
		  isVowel = true;
		  for(int j=0; j<Letters.length;j++)	
		  {
		    if(copyInput.substring(i, i+1).equalsIgnoreCase(Letters[j]) && isVowel == true) 
		    {
		      aNum = j; 
		      System.out.print("-");	
		      isVowel = false; 		    
			}	                		  
	      }
	      if(aNum < posVowel)
		    isPos = false;
		  else
			posVowel = aNum;
		}	
				
		for(int i=0; i<copyInput.length() && isReversePos == true;i++)///////Checks if input is alphabetical
		{		
		  System.out.print(copyInput.charAt(i));
	      isVowel = true;
		  for(int j=0; j<Letters.length;j++)	
		  {
		    if(copyInput.substring(i, i+1).equalsIgnoreCase(Letters[j]) && isVowel == true) 
		    {
		      aNum = j; 
			    System.out.print("-");	
				isVowel = false; 		    
			}	                		  
	      }
		  if(aNum > reversePosVowel)
		    isReversePos = false;
		  else
		    reversePosVowel = aNum;
		}	
	    if (isPos)
		  result+=  copyInput + " contains all the vowels in alphabetical order." + "\n"	;	
		if (isReversePos)
	      result+=  copyInput + " contains all the vowels in reverse alphabetical order." + "\n"	;
	  }
      for (int i=0;i<Letters.length;i++) ////////checks frequency
      { 
	    freq =0;  	   	  
        for(int j =0;j<inputLetters.length;j++)
        {	    	   
	      if(Letters[i].equals(inputLetters[j]))
	        freq++;
	     }
	     if(freq>0 && Letters[i] != Letters[0])
	       result +="The letter " + Letters[i] + " appears " + freq + " Time(s)" + "\n" ;
	  }    							
	  System.out.println("Position = " + isPos + "\n");
	  System.out.println("Reverse position = " + isReversePos + "\n");
	  JOptionPane.showMessageDialog(null, result);
	}
	
//////////Method 2///////	
	public static void ConsonantContent()
	{
	  String consonant = "bcdfghjklmnpqrstvwxyz";
	  String[] conLetters = consonant.split(""); 
	  String message = "Please enter a word, sentence or phrase.";
	  String title= "Consonant analysis";
	  String pattern = "([a-zA-Z]+)|(([a-zA-Z]+\\s[a-zA-Z]+)+)";
	  String userInput = getWordPhraseFromUser(message, title, pattern);    
	  String copyInput = userInput;
	  userInput = userInput.toLowerCase();    
	  String[] inputLetters= userInput.split("");
	  String aChar = "";
	  boolean isPos = true; 
	  boolean isReversePos = true; 
	  boolean isConsonant = true;
	  String result = "";
	  int posCon = -1;
	  int reversePosCon=conLetters.length;        
	  int posNum = 0, aNum = -1;
	  int conCount = 0;
	  int freq=0;	        
	  for(int i = 0;i<consonant.length();i++)
	  {
	    aChar = consonant.substring(i,i+1);
        if(userInput.indexOf(aChar)!=-1)	    
	      posNum++;	    
	  }              
	  if (posNum ==0) 
	  {
		result+= "String contains no consonants" + "\n";
      }
	  else if (posNum ==22) 
	  {
	    result+= "String contains all consonants in any order" + "\n";
	  }       
	  for(int i = 0;i<userInput.length();i++)
	  {
	    aChar = userInput.substring(i,i+1);
	    if(consonant.indexOf(aChar)!=-1)
	    {  
	      conCount++;
	    }	      
	  }	
      result+= "Consonant Count = " + conCount + "\n";	
	  for (int i=0;i<conLetters.length;i++)//Frequency Check
	  { 
	    freq =0;  	   	  
	    for(int j =0;j<inputLetters.length;j++)
	    {	    
		  if(conLetters[i].equals(inputLetters[j]))
		  {
		    freq++;
		    System.out.println(freq); 		  
          }	   
	    }
		if(freq>0 && conLetters[i] != conLetters[0])
		result +="The letter " + conLetters[i] + " appears " + freq + " Times" + "\n" ;
      }    	    
		
					
		  System.out.println("Position = " + isPos + "\n");
		  System.out.println("Reverse position = " + isReversePos + "\n");
		  JOptionPane.showMessageDialog(null, result);
	}
	 public static void IsPalindrome()
   {
		int length, i, j;
		String y,  result, userInput, tempInput, s;
		
		userInput = JOptionPane.showInputDialog(null, "Please input a word.");
		
		if (userInput != null)
		{
			if (userInput.equals(""))
			{
				JOptionPane.showMessageDialog(null, "No input provided!");
			}
			else if (userInput.length()  < 2)
			{
				JOptionPane.showMessageDialog(null, "Please provide a word/phrase/sentence that is more than two characters long!");
			}
			else if ((userInput.replaceAll("[^a-zA-Z]","")).length()==0)
			{
				JOptionPane.showMessageDialog(null, "Please provide input only containing letters");
			}
			else
			{
				tempInput = userInput.replaceAll("[^a-zA-Z]","");		// Removes any non-alphabetic character
				tempInput = tempInput.trim();							// Removes all leading & trailing spaces
				tempInput = tempInput.toLowerCase();					// Converts tempInput to lower case
				
				s = tempInput;
				
				for (i = 0; i < s.length(); i++) 
				{
					s = s.substring(1, s.length() - i)
					+ s.substring(0, 1)
					+ s.substring(s.length() - i, s.length());
				}
				//JOptionPane.showMessageDialog(null, s);
				if (s.equals(tempInput))
				{
					JOptionPane.showMessageDialog(null, userInput + " contains a palindorme");
					System.exit(0);
				}
				else if (!(userInput.contains(" ")))
				{
					JOptionPane.showMessageDialog(null, userInput + " does not contain a palindrome");
				}
				else 
				{
					y = userInput.replaceAll("[^a-zA-Z]","");
					y = y.toLowerCase();
					String[] splitWord = y.split(" ");
					result = "";
				
					for (j = splitWord.length - 1; j >= 0; j--) 
					{
						result += (splitWord[j] );
					}
					if (result.equals(tempInput))
						{
							JOptionPane.showMessageDialog(null, userInput + " contains a palindrome");
							System.exit(0);
						}
					else 
						JOptionPane.showMessageDialog(null, userInput + " does not contain a palindrome");
				} 
				}
			}
		}
	
	public static void determineLongestAndShortestWords(){

			String title = "Longest and Shortest words";
			String message = "Enter word or phrase";
		    String pattern = "([\\w]+)";
			String inputtedString;
			
            inputtedString = getWordPhraseFromUser(message, title, pattern);
			String[] aString = inputtedString.replaceAll("[^a-zA-Z0-9\\s+]","").split("\\s+");
			String temp, sLongWords="", sShortWords="";

			//sort array and put same words one after another
			for(int j=0; j<aString.length;j++){
			    for (int i=j+1 ; i<aString.length; i++){

			    	//sorts words by length longest to shortest
			      	if(aString[i].length()>aString[j].length()){
				        temp = aString[j];
				        aString[j] = aString[i]; 
				        aString[i] = temp;
			       	}

			       	//groups the same words together
			       	if (j>0) {		       	
				       	if(aString[i].toLowerCase().equals(aString[j-1].toLowerCase())){
					        temp = aString[j];
					        aString[j] = aString[i];
					        aString[i] = temp;
				       	}
			       	}
			   	}
			}

			sLongWords = getMatchingStrings(aString, 0);
			sShortWords = getMatchingStrings(aString, aString.length-1);

			JOptionPane.showMessageDialog( null, inputtedString + "\nMax length: " + aString[0].length() + ". Words matching this length are: " + sLongWords + "\nMin length: " + aString[aString.length-1].length() + ". Words matching this length are: " + sShortWords);

			}
			//shane
	public static String getMatchingStrings(String [] aString, int iPosition){
		String sMatch = "";

		//check for longest and shortest words
		for (int i=0;i<aString.length;i++) {
			if (aString[i].length()==aString[iPosition].length()) {

				//check if string is a duplicate or not
				if (i==0 || !aString[i].toLowerCase().equals(aString[i-1].toLowerCase())) {
					sMatch+=aString[i] + ", ";
				}
			}	
		}

		sMatch = sMatch.substring(0, sMatch.length()-2)+".";
		
		return sMatch;
	}
public static void areWordsOrPhrasesAnagrams() {
        String title = "Is anagram";
		String message = "Enter first word or phrase";
		String pattern = "([^0-9]+)";
		String [] aString1, aString2;
		String inputtedString1, inputtedString2, anagramboolean = "";
		inputtedString1 = getWordPhraseFromUser(message, title, pattern);
		message = "Enter second word or phrase";
        inputtedString2 = getWordPhraseFromUser(message, title, pattern);
		

		//run sort method for each string
		aString1 = getSortedArray(inputtedString1);
		aString2 = getSortedArray(inputtedString2);
	
		if (!Arrays.equals(aString1, aString2)) {
			anagramboolean = "not ";
		}

		//System.out.print(inputtedString1 + " and " + inputtedString2 + " are " + anagramboolean + "anagrams.");
		JOptionPane.showMessageDialog( null, inputtedString1 + " and " + inputtedString2 + " are " + anagramboolean + "anagrams.");


	}
	//Shane
	public static String [] getSortedArray(String p_input){
		//split array
		String [] v_array = p_input.toLowerCase().replaceAll("[^a-z]","").split("(?!^)");	
		String temp;

		//sort array 
		for(int j=0; j<v_array.length;j++){
		    for (int i=j+1; i<v_array.length; i++){

		    	//sort a-z
		      	if(v_array[i].compareTo(v_array[j])>0){
			        temp = v_array[j];
			        v_array[j] = v_array[i]; 
			        v_array[i] = temp;
		       	}
		   	}
		}
			
		return v_array;
	}
	public static void rowsOnqwertyKeyboard()
  {
    String results = "";
    String rowOne = ".*[q,w,e,r,t,y,u,i,o,p].*";
    String rowTwo = ".*[a,s,d,f,g,h,j,k,l].*";
    String rowThree = ".*[z,x,c,v,b,n,m].*";
    String errorInput = ("Invalid input, please try again");
    String R1 = "";
    String R2 = "";
    String R3 = "";

    String userInput = JOptionPane.showInputDialog(null, "Please Enter A Word/Phrase/Sentence");
    while(!(userInput.matches("[a-zA-Z]+"))){
      System.out.println(errorInput);
      userInput = JOptionPane.showInputDialog(null, "Please Enter A Word/Phrase/Sentence");
    }
    String [] splitted = userInput.split("(?!^)");

    for(int i = 0; i < splitted.length; i++){

        if(splitted[i].matches(rowOne)){
          R1 = "Row 1";
        }
        else if(splitted[i].matches(rowTwo)){
          R2 = " Row 2";
        }
        else{
            R3 = " Row 3";
          }
        }
    JOptionPane.showMessageDialog(null, userInput + " uses " + R1 + R2 + R3);

  }
  public static void Alternating() 
	{
		String vowels = "aeiou";
		String consonants = "bcdfghjklmnpqrstvwxyz";
		boolean alternate = true;
		
		String userInput = JOptionPane.showInputDialog(null, "Please enter a word/phrase/sentence for analyzation.", "Input", 3); 
		
		if (userInput != null)
		{
			if (userInput.equals(""))
			{
				JOptionPane.showMessageDialog(null, "No input provided!", "Error", 2);
			}
			else if (userInput.length() < 2)
			{
				JOptionPane.showMessageDialog(null, "Please provide a word/phrase/sentence that is more than two characters long!", "Error", 2);
			}
			else if ((userInput.replaceAll("[^a-zA-Z]","")).length()==0)
			{
				JOptionPane.showMessageDialog(null, "Please provide input only containing letters", "Error", 2);
			}
			else
			{
				String tempInput = userInput.replaceAll("[^a-zA-Z]","");
				userInput = userInput.toLowerCase();											//Changes input to lower case
				userInput = userInput.replaceAll("[^a-zA-Z]","");								//Removes any non-alphabetic character
				userInput = userInput.trim();													//Removes all leading and trailing white spaces
		
		
				for (int i = 0; i < userInput.length() - 1 && alternate; i++) 					//Checks first letter.
				{
					if (vowels.contains(userInput.substring(i, i + 1))) 						//Checks if its a vowel.
					{
						if (consonants.contains(userInput.substring(i + 1, i + 2)))
						{
						alternate = true;														//If next letter is a consonant boolean is true.
						}
						else 
						{
							alternate = false;
						}
					}
					else if (consonants.contains(userInput.substring(i, i + 1))) 				//Same as previous if statement but sees if next letter is a vowel
					{
						if (vowels.contains(userInput.substring(i + 1, i + 2)))
						{
						alternate = true;
						}
						else
						{
							alternate = false;
						}
					}
					else
					{
						alternate = false;
					}
				}
				if (!alternate)
				{					
					JOptionPane.showMessageDialog(null, tempInput + " doesn't contain alternating vowels and consonants");
				}
				else
				{	
					JOptionPane.showMessageDialog(null, tempInput + " does contain alternating vowels and consonants");
				}
			}
		}
	}
	public static void AnalyzeWordSentenceContent()
  {
    int charCount = 0, numCount = 0, symCount = 0;

    String userInput = JOptionPane.showInputDialog(null, "Enter Word/Phrase/Sentence", "Hello" , 1);
    userInput = userInput.replaceAll("\\s","");
    String [] splitted = userInput.split("(?!^)");
    if(userInput == null || userInput == "0"){
        System.exit(0);
      }else

    for(int i = 0; i < userInput.length(); i++)
    {
      if(splitted[i].matches("[a-zA-Z]+")){
         charCount += 1;
       }
      else if(splitted[i].matches("[0-9]+")){
        numCount += 1;
      }else{
        symCount += 1;
      }
    }
    JOptionPane.showMessageDialog(null, "Alphabetical count: " + charCount + "\nNumerical Count: " + numCount + "\nSymbol Count: " + symCount, "Count" ,3);

    int s=0,f=-1;
    for(int i=0;i<userInput.length();i++)
    {
     for(int j=0;j<userInput.length();j++)
     {
      if(userInput.charAt(i)==userInput.charAt(j))
      s++;
     }
     for(int k=0;k<i;k++)
     {
      if(userInput.charAt(i)==userInput.charAt(k))
      f = 1;
     }
     if(f==-1)
      JOptionPane.showMessageDialog(null, userInput.charAt(i) +" = " +s, "Frequency", 3);
     s=0;
     f=-1;
    }
  }
}
