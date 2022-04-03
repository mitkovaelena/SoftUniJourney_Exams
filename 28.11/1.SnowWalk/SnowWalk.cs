using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SnowWalk
{
    class Program
    {
        static void Main(string[] args)
        {
            double len = double.Parse(Console.ReadLine());
            double wid = double.Parse(Console.ReadLine());
            double shovel = double.Parse(Console.ReadLine());

            double walk  = Math.Ceiling(wid/shovel)*len;

            walk += Math.Sqrt(len*len + wid*wid);

            Console.WriteLine(walk);
        }
    }
}
