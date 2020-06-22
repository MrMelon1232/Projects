import java.util.Random;
// ----------------------------------------------------------
// Assignment 3
// Written by: Julien Phan  id: 40133814
// For COMP 248 Section R - Fall 2019
// ----------------------------------------------------------

// Question 1 (Single/multi Dimensional Arrays)

// This program generates a random password composed of three words from
// a few selected pages from "Alice in Wonderland" by Lewis Carroll


public class Assignment3Q11 
{


	public static void main(String[] args) 
	
	{
		// Declaration of Array
		// http://www.gutenberg.org/cache/epub/19033/pg19033.txt
		final String [] [] [] book = 
		{ 
				
		{
	
			  {"ALICE was beginning to get very tired of sitting by her sister on the\n", 
			  "bank, and of having nothing to do. Once or twice she had peeped into the\n",
			  "book her sister was reading, but it had no pictures or conversations in\n",
			  "it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n",
			  "conversations?\"\n"},
			  
			  {"So she was considering in her OWN mind (as well as she could, for the\n",
			  "day made her feel very sleepy and stupid), whether the pleasure of\n",
			  "making a daisy-chain would be worth the trouble of getting up and\n",
			  "picking the daisies, when suddenly a White Rabbit with pink eyes ran\n",
			  "close by her.\n"},
			  
			  
			  {"There was nothing so very remarkable in that, nor did Alice think it so\n",
			  "very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
		      "dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
		      "out of its waistcoat-pocket and looked at it and then hurried on, Alice\n", 
			  "started to her feet, for it flashed across her mind that she had never\n",
			  "before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
			  "out of it, and, burning with curiosity, she ran across the field after\n",
			  "it and was just in time to see it pop down a large rabbit-hole, under\n",
			  "the hedge. In another moment, down went Alice after it!"}
		},
		{
			  {"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n",
			   "telescope!\"\n"},
			  
			  {"And so it was indeed! She was now only ten inches high, and her face\n",
			  "brightened up at the thought that she was now the right size for going\n",
			  "through the little door into that lovely garden.\n"},
			 
			  {"After awhile, finding that nothing more happened, she decided on going\n",
			  "into the garden at once; but, alas for poor Alice! When she got to the\n",
			  "door, she found she had forgotten the little golden key, and when she\n",
			  "went back to the table for it, she found she could not possibly reach\n",
			  "it: she could see it quite plainly through the glass and she tried her\n",
			  "best to climb up one of the legs of the table, but it was too slippery,\n",
			  "and when she had tired herself out with trying, the poor little thing\n",
			  "sat down and cried.\n"},
			  
			  {"\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
		      "sharply. \"I advise you to leave off this minute!\" She generally gave\n",
		      "herself very good advice (though she very seldom followed it), and\n",
		      "sometimes she scolded herself so severely as to bring tears into her\n",
		      "eyes.\n"},
			  
			  {"Soon her eye fell on a little glass box that was lying under the table:\n",
		      "she opened it and found in it a very small cake, on which the words \"EAT\n",
		   	  "ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
		   	  "Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
		   	  "makes me grow smaller, I can creep under the door: so either way I'll\n",
		   	  "get into the garden, and I don't care which happens!\"\n"},
			  
			  
			  {"She ate a little bit and said anxiously to herself, \"Which way? Which\n",
		   	  "way?\" holding her hand on the top of her head to feel which way she was\n",
		      "growing; and she was quite surprised to find that she remained the same\n",
			  "size. So she set to work and very soon finished off the cake."},
		},
		{
			
			{"The King and Queen of Hearts were seated on their throne when they\n",
			"arrived, with a great crowd assembled about them--all sorts of little\n",
			"birds and beasts, as well as the whole pack of cards: the Knave was\n",
			"standing before them, in chains, with a soldier on each side to guard\n",
			"him; and near the King was the White Rabbit, with a trumpet in one hand\n",				
			"and a scroll of parchment in the other. In the very middle of the court\n",
			"was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
			"trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n"},
			
			{"The judge, by the way, was the King and he wore his crown over his great\n",
			"wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
			"(some were animals and some were birds) I suppose they are the jurors.\"\n"},
		
			{"Just then the White Rabbit cried out \"Silence in the court!\"\n"},
			
			{"\"HERALD! read the accusation!\" said the King."}
			
		} 
		};
		
		
		// Welcome Message
		System.out.println("Welcome to the password generator game!");
		
		// Initializations of Variables
		int i, k, h, l, o,
		Newline =0, Single=0, Equal=0, Length=0, Upper=0, Lower=0, Special=0, 
		count=0, 
		pageNum, paragraphNum, lineNum, wordNum;
		k=0;
		h=0;
		l=0;
		o=0;
		String [] word = new String[3]; 
		String password;
		Random random = new Random();
		boolean valid=true;

		
		// Loop for password
		for(h=0; h < 10000 ; h++) 
		{
			
		// Loop for picking 3 words
		do
		{
		valid=true;
				do
				{
			for (i=0; i < word.length || Lower!=0; i++)
			{
			final int page = book.length;
			pageNum = random.nextInt(page);

			final int paragraph = book[pageNum].length;
			paragraphNum = random.nextInt(paragraph);

			final int line = book [pageNum] [paragraphNum].length;
			lineNum = random.nextInt(line);

			String chosenLine = book [pageNum] [paragraphNum] [lineNum];
			String [] words = chosenLine.split(" ");
			
			
			wordNum = random.nextInt(words.length);
			word[i] = words[wordNum];


			if (word[i].contains("\n"))
			{
				Newline ++;
				count =0;
				break;
			}
			else if (words[i].length() == 1 )
			{
				Single ++;
				count =0;
				break;
			}
			count++;
	}
	}
	while (count != 3);
		
			// Concatenate the password
			password = word[0] + word[1] + word [2];
			
			// Loop for checking every special, capital and lowercase characters.
		for (int j=0; j < password.length(); j++)
			{
				if (password.charAt(j) >= 'a' && password.charAt(j) <= 'z') 
					l ++;
				
				else if (password.charAt(j) >= 'A' && password.charAt(j) <= 'Z')
				{
					o ++;
				}
				else
				{
					k ++;
				}
				}
			
		// Condition check
			if (l == 0)
			{
				Lower +=1;
				valid=false;
			}
			
			else if (o == 0)
			{
				Upper +=1;
				valid=false;
			}
			
			else if (k != 1)
			{
				Special +=1;
				valid=false;
			}
			
			
			else if (word[0].compareTo(word[1]) == 0 || word[0].compareTo(word[2])== 0 || word[1].compareTo(word[2])== 0)
			{
				Equal +=1;
				valid=false;
			}
		
			else if (password.length() < 8 || password.length() >= 16)
			{
				Length+=1;
				valid=false;
			}
			}
			while (valid=false);
				
			
		// Mesasge print and format
		if (password.length() < 13)
		{
			h++;
			System.out.print("Password = " + password);
		System.out.print("\t\tNewline = " + Newline);
		System.out.print("\tSingle = " + Single);
		System.out.print("\tEqual = " + Equal);
		System.out.print("\tLength = " + Length);
		System.out.print("\tUpper = " + Upper);
		System.out.print("\tLower = " + Lower);
		System.out.print("\tSpecial = " + Special);
		System.out.print("\n");
			
		}


		else
		{
		h++;
		System.out.print("Password = " + password);
		System.out.print("\tNewline = " + Newline);
		System.out.print("\tSingle = " + Single);
		System.out.print("\tEqual = " + Equal);
		System.out.print("\tLength = " + Length);
		System.out.print("\tUpper = " + Upper);
		System.out.print("\tLower = " + Lower);
		System.out.print("\tSpecial = " + Special);
		System.out.print("\n");
		}
		
		if( Lower != 0)
		break;

		// Reset count for next password
		Newline =0;
		Single =0;
		Equal =0;
		Length =0;
		Upper =0;
		Lower =0;
		Special=0;
		}
		
		
		
		System.out.println("\nTotal passwords generated: " + h);

		
	

	// Closing message
	System.out.println("\nThanks for using the password generator game. Good bye.");
	
	}
			
}

		