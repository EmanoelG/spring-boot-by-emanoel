--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

-- Started on 2023-05-15 21:31:36

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'LATIN1';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 28524)
-- Name: book; Type: TABLE; Schema: public; Owner: rpdv
--

CREATE TABLE public.book (
    bk_id bigint NOT NULL,
    br_autor character varying(80) NOT NULL,
    br_categoria character varying(80) NOT NULL,
    bk_ano_publicao timestamp(6) without time zone NOT NULL,
    bk_titulo character varying(80) NOT NULL
);


ALTER TABLE public.book OWNER TO rpdv;

--
-- TOC entry 210 (class 1259 OID 28523)
-- Name: book_bk_id_seq; Type: SEQUENCE; Schema: public; Owner: rpdv
--

CREATE SEQUENCE public.book_bk_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.book_bk_id_seq OWNER TO rpdv;

--
-- TOC entry 3319 (class 0 OID 0)
-- Dependencies: 210
-- Name: book_bk_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rpdv
--

ALTER SEQUENCE public.book_bk_id_seq OWNED BY public.book.bk_id;


--
-- TOC entry 3170 (class 2604 OID 28527)
-- Name: book bk_id; Type: DEFAULT; Schema: public; Owner: rpdv
--

ALTER TABLE ONLY public.book ALTER COLUMN bk_id SET DEFAULT nextval('public.book_bk_id_seq'::regclass);


--
-- TOC entry 3313 (class 0 OID 28524)
-- Dependencies: 211
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: rpdv
--

COPY public.book (bk_id, br_autor, br_categoria, bk_ano_publicao, bk_titulo) FROM stdin;
1	J. R. R. Tolkien 	Fantasia	1956-05-06 21:00:00	O Senhor dos Anéis : A Sociedade do Anel
2	J. R. R. Tolkien 	Fantasia	1954-11-10 21:00:00	O Senhor dos Anéis : As Duas Torres
5	string	string	2023-05-06 20:34:31.12	string
6	string	string	2023-05-06 20:34:31.12	string
7	string	string	2023-05-06 20:34:31.12	string
8	string	string	2023-05-06 20:34:31.12	string
\.


--
-- TOC entry 3320 (class 0 OID 0)
-- Dependencies: 210
-- Name: book_bk_id_seq; Type: SEQUENCE SET; Schema: public; Owner: rpdv
--

SELECT pg_catalog.setval('public.book_bk_id_seq', 8, true);


--
-- TOC entry 3172 (class 2606 OID 28529)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: rpdv
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (bk_id);


-- Completed on 2023-05-15 21:31:36

--
-- PostgreSQL database dump complete
--

