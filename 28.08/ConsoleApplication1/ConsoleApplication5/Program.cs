using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication5
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = Int32.Parse(Console.ReadLine());

            int i = 1;
            int m = 3*n;
            for (i = 0; i < n; i++)
            {
                Console.WriteLine(new string('-',m) + '*' + new string('-', i) + '*' + new string('-', 5 * n - (m + i + 2)));   
            }
            i--;
            for (int j = 1; j <= Math.Floor(n/2.0); j++)
            {
                Console.WriteLine(new string('*', m) + '*' + new string('-', i) + '*' + new string('-', 5 * n - (m + i + 2)));
            }
            
            for (int g = 1; g <= Math.Floor(n / 2.0); g++)
            {
                if(g == Math.Floor(n / 2.0))
                Console.WriteLine(new string('-', m--) + '*' + new string('*', i++) + '*' + new string('-', 5 * n - (m + ++i + 1)));
                else
                Console.WriteLine(new string('-', m--) + '*' + new string('-', i++) + '*' + new string('-', 5 * n - (m + ++i + 1)));
            }
        }
    }
}
