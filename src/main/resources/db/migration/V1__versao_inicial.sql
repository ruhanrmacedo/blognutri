CREATE TABLE IF NOT EXISTS public.blog
(
    id serial8,
    title character varying(255),
    image character varying(255),
    description character varying(1000),
    CONSTRAINT blog_pkey PRIMARY KEY (id)
    );