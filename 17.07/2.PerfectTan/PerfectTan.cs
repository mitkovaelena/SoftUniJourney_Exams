using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PerfectTan
{
    class Program
    {
        static void Main()
        {
            int holidays = int.Parse(Console.ReadLine());
            double pool = double.Parse(Console.ReadLine());
            double sea = double.Parse(Console.ReadLine());
            int cream = int.Parse(Console.ReadLine());

            double hoursTan = holidays*(pool + sea*1.15 - cream*1.5);

            if (hoursTan == 38.0)
            {
                Console.WriteLine("Svetlana will have the perfect tan");
                Console.WriteLine("Svetlana will get the job");
            }
            else if (hoursTan < 38.0)
            {
                Console.WriteLine("Svetlana will not get the job");
                Console.WriteLine("{0} minutes less", (38-hoursTan)*60);
            }
            else 
            {
                Console.WriteLine("Svetlana will get a sunburn");
                Console.WriteLine("{0} minutes more", (hoursTan-38) * 60);
            }
        }
    }
}
