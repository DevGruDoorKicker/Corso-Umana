/*Exercises

1. Write a query that generates a virtual auxiliary table of 10 numbers in the range 1 through 10 without using a looping construct. You do not need to guarantee any order of the rows in the output of your solution.
Tables involved: None
Output: n

2. Write a query that returns customer and employee pairs that had order activity in January 2016 but
not in February 2016.
Tables involved: Sales.Orders table
Output: custid, empid

3. Write a query that returns customer and employee pairs that had order activity in both January 2016
and February 2016.
Tables involved: Sales.Orders
Output: custid, empid

4. Write a query that returns customer and employee pairs that had order activity in both January 2016
and February 2016 but not in 2015.
Tables involved: Sales.Orders
Output: custid, empid

5. You are given the following query.

SELECT country, region, city
FROM HR.Employees
UNION ALL
SELECT country, region, city
FROM Production.Suppliers;

You are asked to add logic to the query so that it guarantees that the rows from Employees are
returned in the output before the rows from Suppliers. Also, within each segment, the rows should be
sorted by country, region, and city.

Tables involved: HR.Employees and Production.Suppliers
Output: country, region, city

*/

--1

select 1 as n
union all
select 2 
union all
select 3 
union all
select 4 
union all
select 5 
union all
select 6 
union all
select 7 
union all
select 8 
union all
select 9 
union all
select 10 


--2
select custid,empid from Sales.Orders where month(orderdate)='01' and year(orderdate)='2016'
except
select custid,empid from Sales.Orders where (month(orderdate)='02' and year(orderdate)='2016')

--3
select custid,empid from Sales.Orders where month(orderdate)='02' and year(orderdate)='2016'
intersect
select custid,empid from Sales.Orders where month(orderdate)='01' and year(orderdate)='2016'

--4
select custid,empid from Sales.Orders where month(orderdate)='02' and year(orderdate)='2016'
intersect
select custid,empid from Sales.Orders where month(orderdate)='01' and year(orderdate)='2016'
except
select custid,empid from Sales.Orders where year(orderdate)='2015'


--5
select custid,empid from Sales.Orders where month(orderdate)='02' and year(orderdate)='2016'
intersect
select custid,empid from Sales.Orders where month(orderdate)='01' and year(orderdate)='2016'
except
select custid,empid from Sales.Orders where year(orderdate)='2015'

--sbagliata
go
(SELECT country, region, city
FROM HR.Employees
UNION ALL
SELECT country, region, city
FROM Production.Suppliers)
order by country, region, city


--soluzione buona
select country, region, city
from(
	SELECT  1 as id, country, region, city
	FROM HR.Employees
	UNION all
	SELECT  2 as id, country, region, city
	FROM Production.Suppliers
	) as subtab
order by country, region, city,id








