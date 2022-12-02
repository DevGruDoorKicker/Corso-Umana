--dql(data data query language language)
--dml(data manipulation language)
--ddl(data definition language) create/alter/drop

--modello crud ----> create/update/delete/merge

select * from dbo.tb1 as tb1

truncate table dbo.tb1            --rimuove tutte le righe dalla tabella riducendone la dimensione a nullas

--insert values
insert into tb1(id,name) values (1,'a')               --non sono comandi rollbackabili
													  -- concetto di atomicità, uno statement valido verrà preso in ogni caso
													  
insert into tb1(id,name) values (1,'a'),(1,'a') ,(1,'a') ,(1,'a') 

--insert select(serve per il data movement) metto i dati in una tabella di destinazione creando una copia e non toccando i dati originali
insert into tb1(id,name) select * from tb1


--insert excec
-- using *procedures*

--bulk insert
bulk insert tb1 from 'C:\\TMP\txt.txt'
with(
fieldterminator=',',
rowterminator='\n'
)

--delete
delete from tb1        --cancellazione che non riduce la dimensione della tabella ma cancella tutto
--where *cond*		   --il delete è compatibile con il join
where id>10

begin tran
delete from o                            --senza tran c'è una chiave fk che impedisce di cancellare
from sales.orders as o
inner join Sales.Customers as c
on c.custid=o.custid
where c.country='USA'
rollback tran




--update
update tb1 
	set name='.',id=2
where id>10


update od
	set discount +=0.05
from Sales.OrderDetails as od
join sales.orders as o
on od.orderid=o.orderid
where o.custid=1


--output
insert into tb1
output inserted.id, inserted.name
select empid,firstname from hr.employees


delete from tb1
output deleted.id, deleted.name
select id,name from tb1

update tb1 
	set name=upper(name)
output inserted.id, inserted.name as newName, deleted.name as oldName








select * from tb1

