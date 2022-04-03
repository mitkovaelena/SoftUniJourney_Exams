using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication4
{
    class Program
    {
        static void Main(string[] args)
        {
            int docs = 7;
            int treated = 0;
            int untreated = 0;
            int n = int.Parse(Console.ReadLine());
            for (int i = 1; i <= n; i++)
            {
               if (i%3 == 0)
                {
                    if (untreated > treated) docs++;
                }

                int patientsToday = int.Parse(Console.ReadLine());

                if (patientsToday >= docs)
                {
                    treated += docs;
                    untreated += patientsToday - docs;
                }
                else
                {
                    treated += patientsToday;
                }


            }

            Console.WriteLine($"Treated patients: {treated}.");
            Console.WriteLine($"Untreated patients: {untreated}.");
        }
    }
}
