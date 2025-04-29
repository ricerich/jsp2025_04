SELECT 
        IDX, NAME, TITLE, CONTENT, POSTDATE,
        OFILE, SFILE, DOWNCOUNT, PASS,	VISITCOUNT,
        rNUM
FROM (    
        SELECT 
                Tb.*, ROWNUM rNum 
          FROM
              (SELECT 
                        * 
                 FROM 
                        mvcboard
                WHERE 
                        TITLE LIKE '%제목5%'         
             ORDER BY idx DESC     
              ) Tb
     )  
WHERE 
      rNum BETWEEN 1 AND 10;
