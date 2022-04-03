using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VampireNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            for (int a = 1; a < 9; a++)
            {
                for (int b = 0; b < 9; b++)
                {
                    for (int c = 0; c < 9; c++)
                    {
                        for (int d = 0; d < 9; d++)
                        {
                            if (a != b && a != c && a != d && b != c && b != d && c != d)
                            {
                                if (a+b+c-d == n)
                                Console.Write("{0}{1}{2}{3} ", a, b, c, d);
                            }
                        } 
                    }
                } 
            }
        }
    }
}
