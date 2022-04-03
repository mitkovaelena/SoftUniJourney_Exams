using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EXAM
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Console.WriteLine("{0}/\\{0}", new string('.', 2 * n - 1));
            Console.WriteLine("{0}\\/{0}", new string('.', 2 * n - 1));
            for (int k = 0; k < 2 * n; k++)
            {
                Console.WriteLine("{0}*{1}{1}*{0}", new string('.', 2 * n - 1 - k), new string(' ', k));
            }
            Console.WriteLine("{0}", new string('*', 4 * n));
            Console.WriteLine("*{0}*", new string(' ', 4 * n - 2));
            Console.WriteLine("{0}", new string('*', 4 * n));
        }
    }
}
