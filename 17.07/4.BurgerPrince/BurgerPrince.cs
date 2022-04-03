using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BurgerPrince
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int holidays = int.Parse(Console.ReadLine());
            double price = double.Parse(Console.ReadLine());

            double burgers = 0;
            for (int i = 1; i <= n; i++)
            {
                burgers += 1*1.5;
                if (i%2 == 0)
                {
                    burgers += 12*12;
                }
                else
                {
                    burgers += (12*1.25)*12;
                }
            }

            burgers -= holidays*n;
            burgers *= 2;
                burgers /=3;
            
            Console.WriteLine("Plamen has eaten {0:F2} burgers and has spent {1:F2} leva for them", burgers, burgers*price);
           

        }
    }
}
