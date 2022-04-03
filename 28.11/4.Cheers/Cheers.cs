using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cheers
{
    class Program
    {
        static void Main(string[] args)
        {
            int years = int.Parse(Console.ReadLine());
            int holidays = int.Parse(Console.ReadLine());

            double litersBeer = 0;
            for (int i = 1; i <= years; i++)
            {
                litersBeer += 6*0.330;
                if (i % 2 == 0)
                {
                    litersBeer += 12 * 12;
                }
                else
                {
                    litersBeer += (12 * 1.25) * 12;
                }
                litersBeer -= 2*0.330*holidays;
            }

            litersBeer = (litersBeer*2)/3;
         
            Console.WriteLine("Ivan drank {0:F2} liters beer, which are exactly {1} bottles", litersBeer, Math.Ceiling(litersBeer/ 0.330));

        }
    }
}
