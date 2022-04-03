using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());
            double money = double.Parse(Console.ReadLine());
            double course = double.Parse(Console.ReadLine());

            double salary = days*money*14.5;
            salary -= salary*0.25;
            salary *= course/365;

            Console.WriteLine(salary);

        }
    }
}
