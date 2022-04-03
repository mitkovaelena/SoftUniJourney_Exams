using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BiK
{
    class Program
    {
        static void Main()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int c = int.Parse(Console.ReadLine());
            int d = int.Parse(Console.ReadLine());

            int aa = int.Parse(Console.ReadLine());
            int bb = int.Parse(Console.ReadLine());
            int cc = int.Parse(Console.ReadLine());
            int dd = int.Parse(Console.ReadLine());

            int bikove= 0;
            int kravi = 0; 

            if (a == aa) bikove++;
            if (b == bb) bikove++;
            if (c == cc) bikove++;
            if (d == dd) bikove++;

            if (a == bb || a == cc || a == dd) kravi++;
            if (b == aa || b == cc || b == dd) kravi++;
            if (c == aa || c == bb || c == dd) kravi++;
            if (d == aa || d == bb || d == cc) kravi++;

             Console.WriteLine("Bulls: {0}, Cows: {1}", bikove, kravi);


        }
    }
}
