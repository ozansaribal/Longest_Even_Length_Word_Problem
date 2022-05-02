using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;


class Result
{

    /*
     * Complete the 'longestEvenWord' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING sentence as parameter.
     */

    public static string longestEvenWord(string sentence)
    {
        
        int n = sentence.Length;
        
        int i = 0;
        
        // I store the length of current word
        int currLen = 0;
        
        // I store the length of maximum length word
        int maxLen = 0;
        
        // I store starting index of maximum length word
        int st = -1;
        
        while(i<n){
            
            // If current character is space then word has ended.
            // Check if it is even length word or not.
            // If yes then compare length with maximum length found so far
            if(sentence[i] == ' '){
                
                if(currLen % 2 == 0){
                    
                    if(maxLen < currLen){
                        
                        maxLen = currLen;
                        
                        st = i - currLen;
                        
                    }
                    
                }
                
                // I set the current length to zero for the next word
                currLen = 0;
                
            }
            else{
                
                // I update the length of current word
                currLen++;
                
            }
            
            i++;
                
        }
        
        // I check the length of the last word
        if(currLen % 2 == 0){
            
            if(maxLen < currLen){
                
                maxLen = currLen;
                
                st = i - currLen;
                
            }
            
        }
        
        // If no even length word is present, then return -1
        if(st == -1){
            
            return "00";
            
        }
        
        return sentence.Substring(st,maxLen);
        
    }

}
class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string sentence = Console.ReadLine();

        string result = Result.longestEvenWord(sentence);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
