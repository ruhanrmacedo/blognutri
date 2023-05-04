ALTER TABLE IF EXISTS public.blog
    ALTER COLUMN title TYPE varchar(500),
    ALTER COLUMN image TYPE varchar(500),
    ALTER COLUMN description TYPE varchar(2000);