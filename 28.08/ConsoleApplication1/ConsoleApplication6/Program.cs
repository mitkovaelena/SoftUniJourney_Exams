using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication6
{
    class Program
    {
        static void Main(string[] args)
        {
            string xx = Console.ReadLine();
            int one = int.Parse(xx.Substring(0, 1));
            int two = int.Parse(xx.Substring(1, 1));
            int three = int.Parse(xx.Substring(2, 1));
            int x = int.Parse(xx);

            for (int i = 0; i < one+two; i++)
            {
                for (int j = 0; j < one+three; j++)
                {
                    if (x%5 == 0) x -= one;
                    else if (x%3 == 0) x -= two;
                    else x += three;
                    Console.Write(x + " ");
                }
                Console.WriteLine();
            }
        }
    }
}
