

/* 1-1. Write a query that returns the maximum value in the orderdate column for each employee.
Tables involved: Sales.Orders table
Output: empid, maxorderdate
 */


















/*
1-2. Encapsulate the query from Exercise 1-1 in a derived table. Write a join query between the derived
table and the Orders table to return the orders with the maximum order date for each employee.
Tables involved: Sales.Orders
Output: empid, orderdate, orderid, custid
*/
/*
2-1. Write a query that calculates a row number for each order based on orderdate, orderid ordering.
Tables involved: Sales.Orders
Output: orderid, orderdate, custid, empid, rownum
 */
 /*
2-2. Write a query that returns rows with row numbers 11 through 20 based on the row number definition
in Exercise 2-1. Use a CTE to encapsulate the code from Exercise 2-1.
Tables involved: Sales.Orders
Output: orderid, orderdate, custid, empid, rownum
*/
/* 
3. Write a solution using a recursive CTE that returns the management chain leading to Zoya
Dolgopyatova (employee ID 9).
Tables involved: HR.Employees
Output: empid, mgrid, firstname, lastname
 */


go
with empsCte as (
select empid, mgrid, firstname, lastname from HR.Employees                    
where empid=9
union all                                                            --la prima iterazione mi darebbe empid(9)=mgrid(5) che si chiemerà p																	 --poi quella dopo mi dà empid(5)...

select e.empid, e.mgrid, e.firstname, e.lastname from empsCte as p   --p come parent
join hr.employees as e
on e.empid=p.mgrid
) select* from empsCte











 /* 
4-1. Create a view that returns the total quantity for each employee and year.
Tables involved: Sales.Orders and Sales.OrderDetails
SELECT * FROM Sales.VEmpOrders ORDER BY empid, orderyear;
Output: empid, orderyear, qty
 */


 select * from Sales.Orders

go

drop view Sales.VEmpOrders

create view Sales.VEmpOrders
as
select sum(qty) as conta, year(orderdate)as orderyear, empid from Sales.Orders o, Sales.OrderDetails od
where o.orderid=od.orderid
group by  empid, year(orderdate)               --order by non può essere in una view ma potrei mettercela mettendo una top(100%)

SELECT * FROM Sales.VEmpOrders
order by empid, orderyear
 



 /* 
4-2. Write a query against Sales.VEmpOrders that returns the running total quantity for each employee
and year.
Tables involved: Sales.VEmpOrders view
Output: empid, orderyear, qty, runqty
 */

go
create view Sales.VEmpOrdersAlt
as
select * from Sales.VEmpOrders order by empid, orderyear

select o1.conta, o1.empid, o1.orderyear,
(select sum(o2.conta) from Sales.VEmpOrders as o2 where o2.orderyear<=o1.orderyear and o2.empid=o1.empid) as runqty     
from Sales.VEmpOrders as o1
order by o1.empid, o1.orderyear asc




 /* 
5-1. Create an inline function that accepts as inputs a supplier ID (@supid AS INT) and a requested number of products (@n AS INT). The function should return @n products with the highest unit prices that
are supplied by the specified supplier ID.
Tables involved: Production.Products
SELECT * FROM Production.TopProducts(5, 2);
Output: productid, productname, unitprice
 */
 select productid,productname,categoryid,unitprice,supplierid   from Production.Products

go
create function dbo.GetCustom (@supid as int,@n AS INT) returns table
as
return select top(@n)unitprice,productid, productname, unitprice as top3  from Production.Products where supplierid=@supid 
order by unitprice desc
go

drop function dbo.GetCustom

select * from dbo.GetCustom(18,1) as o

select od.productid,od.qty from dbo.GetCustOrders(1) as os inner join Sales.OrderDetails as od
on os.orderid=od.orderid


go
create function dbo.GetCustOrders (@cid as int) returns table
as
return select * from Sales.Orders where custid=@cid
go

select * from dbo.GetCustOrders(1) as o
select od.productid,od.qty from dbo.GetCustOrders(1) as os inner join Sales.OrderDetails as od
on os.orderid=od.orderid










/* NON DA FARE
5-2. Using the CROSS APPLY operator and the function you created in Exercise 4-1, return, for each supplier, the two most expensive products.
Output: supplierid, companyname, productid, productname, unitprice
*/