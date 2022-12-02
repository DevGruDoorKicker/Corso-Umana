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


--views, proxano le tabelle cioè accedo alle tabelle tramite loro senza toccare di per sé le stesse

/*
		table	
		
view			procedure


*/


create table tb1(id int, name varchar(50))
select * from tb1


go
create view v1
as
select * from tb1 where id>=2


select * from v1

drop view v1

go
create view v1
as
select * from tb1 where id>=2
 with check option                               --non posso mettere volri sotto al due



 -- inline table functions, danno indietro una tabella
go
create function dbo.GetCustOrders (@cid as int) returns table
as
return select * from Sales.Orders where custid=@cid
go

select * from dbo.GetCustOrders(1) as o
select od.productid,od.qty from dbo.GetCustOrders(1) as os inner join Sales.OrderDetails as od
on os.orderid=od.orderid




