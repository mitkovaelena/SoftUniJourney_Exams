using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RoomPaint
{
    class Program
    {
        static void Main(string[] args)
        {
            double a = double.Parse(Console.ReadLine());
            double b = double.Parse(Console.ReadLine());
            double r = double.Parse(Console.ReadLine());

            double walls = 2 * a * a;
            walls += 2 * a * a / 2;
            walls += (b - a) * (a / 2);
            walls -= (Math.PI * r * r) / 2;

            double celling = 2 * a * (a / 2);

            double greenPaint = walls / 3;
            greenPaint *= 1.05;
            double redPaint = celling / 5;
            redPaint *= 1.05;

            Console.WriteLine(greenPaint);
            Console.WriteLine(redPaint);

        }
    }
}
