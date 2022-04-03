using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {
            int hours = int.Parse(Console.ReadLine());
            int days = int.Parse(Console.ReadLine());
            int ppl = int.Parse(Console.ReadLine());

            double workingHours = (days - days*0.1) * 8;
            workingHours += days*ppl*2;
            workingHours = Math.Floor(workingHours);

            if (workingHours >= hours)
            {
                Console.WriteLine($"Yes!{workingHours-hours} hours left.");
            }

            else
            {
                Console.WriteLine($"Not enough time!{hours-workingHours} hours needed.");
            }

        }
    }
}
