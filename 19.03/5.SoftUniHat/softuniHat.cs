using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int m = 8 * n;
            int k = 0;
            for (k = 0; k < 2 * n; k++)
            {
                m -= 4;
                Console.WriteLine("{0}{1}", new string(' ', m), new string('#', 8 * k + 1));
            }
            k--;
            for (int j = 0; j < n - 2; j++)
            {
                m += 4;
                k--;
                Console.WriteLine("|{0}{1}", new string(' ', m - 1), new string('#', 8 * k + 1));
            }
            m += 4;
            k--;
            for (int j = 0; j < n; j++)
            {
                if (j < n - 1)
                    Console.WriteLine("|{0}{1}", new string(' ', m - 1), new string('#', 8 * k + 1));
                else
                    Console.WriteLine("@{0}{1}", new string(' ', m - 1), new string('#', 8 * k + 1));
            }

        }
    }
}
