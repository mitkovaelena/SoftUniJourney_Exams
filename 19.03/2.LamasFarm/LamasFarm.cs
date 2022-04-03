using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FlowerShop
{
    class Program
    {
        static void Main(string[] args)
        {

            double capital = double.Parse(Console.ReadLine());
            int llamas = int.Parse(Console.ReadLine());
            int area = int.Parse(Console.ReadLine());


            double price = 0;

            if (llamas >= 1 && llamas <= 5)
            {
                price += 90 * llamas * (25 + 5 + 7);
            }
            else if (llamas >= 6 && llamas <= 50)
            {
                price += 90 * llamas * (22.75 + 4.50 + 7 * 0.97);
            }
            else
            {
                price += 90 * llamas * (19.50 + 3 + 7 * 0.97 * 0.95);
            }

            price += area * 150 + 58 * llamas + 58 * 0.25 * llamas;

            Console.WriteLine("{0:F2}", price);
            Console.WriteLine("{0:F2}", capital - price);

        }
    }
}
