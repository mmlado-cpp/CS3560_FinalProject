--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-05-09 00:47:40

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
-- TOC entry 214 (class 1259 OID 41030)
-- Name: author; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.author (
    author_id integer NOT NULL,
    name text,
    book_id integer
);


ALTER TABLE public.author OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 41035)
-- Name: author_author_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.author_author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.author_author_id_seq OWNER TO postgres;

--
-- TOC entry 3368 (class 0 OID 0)
-- Dependencies: 215
-- Name: author_author_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.author_author_id_seq OWNED BY public.author.author_id;


--
-- TOC entry 216 (class 1259 OID 41036)
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    item_id integer NOT NULL,
    number_pages integer,
    publisher text,
    publication_date date
);


ALTER TABLE public.book OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 41041)
-- Name: book_book_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.book_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.book_book_id_seq OWNER TO postgres;

--
-- TOC entry 3369 (class 0 OID 0)
-- Dependencies: 217
-- Name: book_book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.book_book_id_seq OWNED BY public.book.item_id;


--
-- TOC entry 218 (class 1259 OID 41042)
-- Name: documentary; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.documentary (
    item_id integer NOT NULL,
    director text,
    length integer,
    release_date text
);


ALTER TABLE public.documentary OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 41047)
-- Name: documentary_item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.documentary_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.documentary_item_id_seq OWNER TO postgres;

--
-- TOC entry 3370 (class 0 OID 0)
-- Dependencies: 219
-- Name: documentary_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.documentary_item_id_seq OWNED BY public.documentary.item_id;


--
-- TOC entry 220 (class 1259 OID 41048)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item (
    item_id integer NOT NULL,
    available boolean,
    title text,
    description text,
    location text,
    daily_price double precision
);


ALTER TABLE public.item OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 41053)
-- Name: item_item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.item_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.item_item_id_seq OWNER TO postgres;

--
-- TOC entry 3371 (class 0 OID 0)
-- Dependencies: 221
-- Name: item_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.item_item_id_seq OWNED BY public.item.item_id;


--
-- TOC entry 225 (class 1259 OID 41098)
-- Name: loan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.loan (
    loan_id integer NOT NULL,
    bronco_id integer NOT NULL,
    item_id integer NOT NULL,
    due_date text NOT NULL,
    loan_date text NOT NULL
);


ALTER TABLE public.loan OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 41097)
-- Name: loan_loan_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.loan_loan_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.loan_loan_id_seq OWNER TO postgres;

--
-- TOC entry 3372 (class 0 OID 0)
-- Dependencies: 224
-- Name: loan_loan_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.loan_loan_id_seq OWNED BY public.loan.loan_id;


--
-- TOC entry 222 (class 1259 OID 41054)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    name text NOT NULL,
    course text NOT NULL,
    email text NOT NULL,
    bronco_id integer NOT NULL
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 41088)
-- Name: student_bronco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_bronco_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_bronco_id_seq OWNER TO postgres;

--
-- TOC entry 3373 (class 0 OID 0)
-- Dependencies: 223
-- Name: student_bronco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_bronco_id_seq OWNED BY public.student.bronco_id;


--
-- TOC entry 3198 (class 2604 OID 41059)
-- Name: author author_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author ALTER COLUMN author_id SET DEFAULT nextval('public.author_author_id_seq'::regclass);


--
-- TOC entry 3199 (class 2604 OID 41060)
-- Name: book item_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book ALTER COLUMN item_id SET DEFAULT nextval('public.book_book_id_seq'::regclass);


--
-- TOC entry 3200 (class 2604 OID 41061)
-- Name: documentary item_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary ALTER COLUMN item_id SET DEFAULT nextval('public.documentary_item_id_seq'::regclass);


--
-- TOC entry 3201 (class 2604 OID 41062)
-- Name: item item_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item ALTER COLUMN item_id SET DEFAULT nextval('public.item_item_id_seq'::regclass);


--
-- TOC entry 3203 (class 2604 OID 41101)
-- Name: loan loan_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loan ALTER COLUMN loan_id SET DEFAULT nextval('public.loan_loan_id_seq'::regclass);


--
-- TOC entry 3202 (class 2604 OID 41089)
-- Name: student bronco_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student ALTER COLUMN bronco_id SET DEFAULT nextval('public.student_bronco_id_seq'::regclass);


--
-- TOC entry 3205 (class 2606 OID 41066)
-- Name: author author_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (author_id);


--
-- TOC entry 3207 (class 2606 OID 41068)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (item_id);


--
-- TOC entry 3209 (class 2606 OID 41070)
-- Name: documentary documentary_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary
    ADD CONSTRAINT documentary_pkey PRIMARY KEY (item_id);


--
-- TOC entry 3211 (class 2606 OID 41072)
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (item_id);


--
-- TOC entry 3215 (class 2606 OID 41105)
-- Name: loan loan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT loan_pkey PRIMARY KEY (loan_id);


--
-- TOC entry 3213 (class 2606 OID 41096)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (bronco_id);


--
-- TOC entry 3216 (class 2606 OID 41073)
-- Name: author fk_book_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author
    ADD CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES public.book(item_id) NOT VALID;


--
-- TOC entry 3218 (class 2606 OID 41078)
-- Name: documentary item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary
    ADD CONSTRAINT item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(item_id) NOT VALID;


--
-- TOC entry 3217 (class 2606 OID 41083)
-- Name: book item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(item_id) NOT VALID;


--
-- TOC entry 3219 (class 2606 OID 41111)
-- Name: loan loan_bronco_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT loan_bronco_id_fkey FOREIGN KEY (bronco_id) REFERENCES public.student(bronco_id);


--
-- TOC entry 3220 (class 2606 OID 41106)
-- Name: loan loan_item_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT loan_item_id_fkey FOREIGN KEY (item_id) REFERENCES public.item(item_id);


-- Completed on 2023-05-09 00:47:40

--
-- PostgreSQL database dump complete
--
