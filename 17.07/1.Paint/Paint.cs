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
            double len = double.Parse(Console.ReadLine());
            double wid = double.Parse(Console.ReadLine());
            double hei = double.Parse(Console.ReadLine());
            double window = double.Parse(Console.ReadLine());

            double walls = 2 * len * hei;
            walls += 2 * wid * hei;
            walls -= 4 * window * window;

            double celling = len * wid;

            double greenPaint = walls / 3;
            greenPaint *= 1.05;
            double whitePaint = celling / 5;
            whitePaint *= 1.05;   

            Console.WriteLine(greenPaint);
            Console.WriteLine(whitePaint);

        }
    }
}
