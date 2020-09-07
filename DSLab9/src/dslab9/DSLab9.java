/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab9;

import java.util.Scanner;

/**
 *
 * @author James
 */
public class DSLab9 {

    /**
     * @param args the command line arguments
     */
    static boolean gameContinued = false;
    
    public static void main(String[] args) {
        
        TreeNode answerOne = new TreeNode("Red maple");
        TreeNode answerTwo = new TreeNode("Austrain pine");
        
        TreeNode questionOne = new TreeNode("Does the tree have flat leaves rather than needles?", answerOne, answerTwo); //Starts the question game off with a question
        
        
        AskQuestion(questionOne);
        
    }
    
    public static void AskQuestion(TreeNode rootNode) //This method runs the question asking game
    {
        TreeNode node = rootNode;
        String answer;
        TreeNode lastQuestion = rootNode; //This gets the last non-leaf question
        
        Scanner scanner= new Scanner(System.in);
       
        while(!node.isLeaf()) //While there are questions to ask before a guess is made
        {
            System.out.println(node.getItem());
            answer = scanner.nextLine();
            
            if(answer.equalsIgnoreCase("yes"))
            {
                    if(!node.left.isLeaf())
                    {
                        lastQuestion = node.left;
                    }
                                
                node = node.left;
            }
            
            else {
                
                if(!node.right.isLeaf())
                    {
                        lastQuestion = node.right;
                    }
                
                node = node.right;
                
                }
        }
        
       // System.out.println(lastQuestion.getItem());
        System.out.println("Is it: " + node.getItem() + "?");
        answer = scanner.nextLine();
            
            if(answer.equalsIgnoreCase("yes"))
            {
                System.out.println("I hope you found this search helpful!");
                EndGame(rootNode);
            }
            
            else
            {
               System.out.println("What is it?");
               TreeNode newAns = new TreeNode(scanner.nextLine());
               System.out.println("What is a question you can use to identify it? (The answer should be YES for the new item and NO for the old)");
               TreeNode newQues = new TreeNode(scanner.nextLine());
               
               newQues.left = newAns;
               newQues.right = node;
               
               if(node == lastQuestion.right) //This area checks if the branch being altered is the "YES" branch or "NO" branch of the last question
                   lastQuestion.right = newQues;
               
            if(node == lastQuestion.left)
                   lastQuestion.left = newQues;
         
               
               System.out.println("Thanks for teaching me about a new tree!");
               
               EndGame(rootNode);
            }
                
        }
    
    static void EndGame(TreeNode rootNode)
    {
         Scanner scanner= new Scanner(System.in);
        System.out.println("Want to search again? Type YES to start a new search.");

        if(scanner.nextLine().equalsIgnoreCase("yes"))
         AskQuestion(rootNode);
        else
         System.out.println("Ta-ta for now!");
    }   
}
