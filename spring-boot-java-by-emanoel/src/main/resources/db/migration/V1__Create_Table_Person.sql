--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

-- Started on 2023-03-14 20:51:43

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 210 (class 1259 OID 28402)
-- Name: person; Type: TABLE; Schema: public; Owner: rpdv
--

CREATE TABLE public.person (
    prs_id bigint NOT NULL,
    prs_address character varying(100) NOT NULL,
    prs_name character varying(80) NOT NULL,
    prs_gender character varying(10),
    prs_last_name character varying(80) NOT NULL
);


ALTER TABLE public.person OWNER TO rpdv;

--
-- TOC entry 211 (class 1259 OID 28405)
-- Name: person_prs_id_seq; Type: SEQUENCE; Schema: public; Owner: rpdv
--

CREATE SEQUENCE public.person_prs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.person_prs_id_seq OWNER TO rpdv;

--
-- TOC entry 3315 (class 0 OID 0)
-- Dependencies: 211
-- Name: person_prs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rpdv
--

ALTER SEQUENCE public.person_prs_id_seq OWNED BY public.person.prs_id;


--
-- TOC entry 3166 (class 2604 OID 28406)
-- Name: person prs_id; Type: DEFAULT; Schema: public; Owner: rpdv
--

ALTER TABLE ONLY public.person ALTER COLUMN prs_id SET DEFAULT nextval('public.person_prs_id_seq'::regclass);


--
-- TOC entry 3308 (class 0 OID 28402)
-- Dependencies: 210
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: rpdv
--

COPY public.person (prs_id, prs_address, prs_name, prs_gender, prs_last_name) FROM stdin;
\.


--
-- TOC entry 3316 (class 0 OID 0)
-- Dependencies: 211
-- Name: person_prs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: rpdv
--

SELECT pg_catalog.setval('public.person_prs_id_seq', 1, false);


--
-- TOC entry 3168 (class 2606 OID 28408)
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: rpdv
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (prs_id);


-- Completed on 2023-03-14 20:51:43

--
-- PostgreSQL database dump complete
--

