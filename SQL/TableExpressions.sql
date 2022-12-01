--Espressioni tabellari
--sono modi per avere dati indietro

--cpe (common table expressions):

-- with cteName
-- as(select)
-- main query da referenziare


--potrei anche rinominare l singole colonne
go
with USACusts as (

select * from Sales.Customers
where country ='USA'
) 
select * from USACusts


--cte multiple
go
with C1 as (
select year(orderdate) as y, custid from Sales.orders
),
C2 as (select custid,count(*)as cnt from C1 group by custid)
select * from C2


--MULTIPLE REFERENCES
go
WITH yearlycounter as(	
select year (orderdate) as orderyear, COUNT(distinct custid) as numcusts
from Sales.Orders
group by year (orderdate)
) select cur.orderyear, (cur.numcusts - prv.numcusts) as customersgrowth from yearlycounter as cur left join yearlycounter as prv
on cur.orderyear=prv.orderyear+1



--senza left
go
WITH yearlycounter as(	
select year (orderdate) as orderyear, COUNT(distinct custid) as numcusts
from Sales.Orders
group by year (orderdate)
) select cur.orderyear, (cur.numcusts - prv.numcusts) as customersgrowth from yearlycounter as cur join yearlycounter as prv
on cur.orderyear=prv.orderyear+1


-- cte ricorsive
go
with ctName as (

<anchor>
union all
<recursive>
)





go
with empsCte as (
select empid, mgrid, firstname, lastname from HR.Employees                    
where empid=2
union all                                                            --

select c.empid, c.mgrid, c.firstname, c.lastname from empsCte as p
join hr.employees as c
on c.mgrid=p.empid
) select* from empsCte


