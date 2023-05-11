--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-05-11 00:35:27

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
-- TOC entry 214 (class 1259 OID 16598)
-- Name: author; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.author (
    author_id integer NOT NULL,
    name text,
    subject text,
    nationality text,
    email text
);


ALTER TABLE public.author OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16603)
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
-- TOC entry 3391 (class 0 OID 0)
-- Dependencies: 215
-- Name: author_author_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.author_author_id_seq OWNED BY public.author.author_id;


--
-- TOC entry 216 (class 1259 OID 16604)
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    item_id integer NOT NULL,
    number_pages integer,
    publisher text,
    publication_date text
);


ALTER TABLE public.book OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16609)
-- Name: book_author; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book_author (
    author_id integer NOT NULL,
    item_id integer NOT NULL
);


ALTER TABLE public.book_author OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16612)
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
-- TOC entry 3392 (class 0 OID 0)
-- Dependencies: 218
-- Name: book_book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.book_book_id_seq OWNED BY public.book.item_id;


--
-- TOC entry 219 (class 1259 OID 16613)
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
-- TOC entry 220 (class 1259 OID 16618)
-- Name: documentary_documentary_producer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.documentary_documentary_producer (
    item_id integer NOT NULL,
    producer_id integer NOT NULL
);


ALTER TABLE public.documentary_documentary_producer OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16621)
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
-- TOC entry 3393 (class 0 OID 0)
-- Dependencies: 221
-- Name: documentary_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.documentary_item_id_seq OWNED BY public.documentary.item_id;


--
-- TOC entry 222 (class 1259 OID 16622)
-- Name: documentary_producer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.documentary_producer (
    producer_id integer NOT NULL,
    name text,
    email text,
    style text,
    nationality text
);


ALTER TABLE public.documentary_producer OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16627)
-- Name: documentary_producer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.documentary_producer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.documentary_producer_id_seq OWNER TO postgres;

--
-- TOC entry 3394 (class 0 OID 0)
-- Dependencies: 223
-- Name: documentary_producer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.documentary_producer_id_seq OWNED BY public.documentary_producer.producer_id;


--
-- TOC entry 224 (class 1259 OID 16628)
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
-- TOC entry 225 (class 1259 OID 16633)
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
-- TOC entry 3395 (class 0 OID 0)
-- Dependencies: 225
-- Name: item_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.item_item_id_seq OWNED BY public.item.item_id;


--
-- TOC entry 229 (class 1259 OID 16721)
-- Name: loan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.loan (
    loan_id integer NOT NULL,
    bronco_id integer,
    item_id integer,
    due_date text,
    loan_date text
);


ALTER TABLE public.loan OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16720)
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
-- TOC entry 3396 (class 0 OID 0)
-- Dependencies: 228
-- Name: loan_loan_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.loan_loan_id_seq OWNED BY public.loan.loan_id;


--
-- TOC entry 227 (class 1259 OID 16712)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    bronco_id integer NOT NULL,
    name text,
    course text,
    email text
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16711)
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
-- TOC entry 3397 (class 0 OID 0)
-- Dependencies: 226
-- Name: student_bronco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_bronco_id_seq OWNED BY public.student.bronco_id;


--
-- TOC entry 3211 (class 2604 OID 16639)
-- Name: author author_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author ALTER COLUMN author_id SET DEFAULT nextval('public.author_author_id_seq'::regclass);


--
-- TOC entry 3212 (class 2604 OID 16640)
-- Name: book item_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book ALTER COLUMN item_id SET DEFAULT nextval('public.book_book_id_seq'::regclass);


--
-- TOC entry 3213 (class 2604 OID 16641)
-- Name: documentary item_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary ALTER COLUMN item_id SET DEFAULT nextval('public.documentary_item_id_seq'::regclass);


--
-- TOC entry 3214 (class 2604 OID 16642)
-- Name: documentary_producer producer_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary_producer ALTER COLUMN producer_id SET DEFAULT nextval('public.documentary_producer_id_seq'::regclass);


--
-- TOC entry 3215 (class 2604 OID 16643)
-- Name: item item_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item ALTER COLUMN item_id SET DEFAULT nextval('public.item_item_id_seq'::regclass);


--
-- TOC entry 3217 (class 2604 OID 16724)
-- Name: loan loan_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loan ALTER COLUMN loan_id SET DEFAULT nextval('public.loan_loan_id_seq'::regclass);


--
-- TOC entry 3216 (class 2604 OID 16715)
-- Name: student bronco_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student ALTER COLUMN bronco_id SET DEFAULT nextval('public.student_bronco_id_seq'::regclass);


--
-- TOC entry 3219 (class 2606 OID 16647)
-- Name: author author_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (author_id);


--
-- TOC entry 3223 (class 2606 OID 16649)
-- Name: book_author book_author_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT book_author_pk PRIMARY KEY (author_id, item_id);


--
-- TOC entry 3221 (class 2606 OID 16651)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (item_id);


--
-- TOC entry 3225 (class 2606 OID 16653)
-- Name: documentary documentary_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary
    ADD CONSTRAINT documentary_pkey PRIMARY KEY (item_id);


--
-- TOC entry 3229 (class 2606 OID 16655)
-- Name: documentary_producer documentary_producer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary_producer
    ADD CONSTRAINT documentary_producer_pkey PRIMARY KEY (producer_id);


--
-- TOC entry 3227 (class 2606 OID 16657)
-- Name: documentary_documentary_producer id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary_documentary_producer
    ADD CONSTRAINT id PRIMARY KEY (item_id, producer_id);


--
-- TOC entry 3231 (class 2606 OID 16659)
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (item_id);


--
-- TOC entry 3235 (class 2606 OID 16726)
-- Name: loan loan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT loan_pkey PRIMARY KEY (loan_id);


--
-- TOC entry 3233 (class 2606 OID 16719)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (bronco_id);


--
-- TOC entry 3237 (class 2606 OID 16660)
-- Name: book_author author_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT author_id_fk FOREIGN KEY (author_id) REFERENCES public.author(author_id) NOT VALID;


--
-- TOC entry 3242 (class 2606 OID 16732)
-- Name: loan item_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT item_fk FOREIGN KEY (item_id) REFERENCES public.item(item_id);


--
-- TOC entry 3239 (class 2606 OID 16670)
-- Name: documentary item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary
    ADD CONSTRAINT item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(item_id) NOT VALID;


--
-- TOC entry 3236 (class 2606 OID 16675)
-- Name: book item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(item_id) NOT VALID;


--
-- TOC entry 3240 (class 2606 OID 16680)
-- Name: documentary_documentary_producer item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary_documentary_producer
    ADD CONSTRAINT item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(item_id);


--
-- TOC entry 3238 (class 2606 OID 16685)
-- Name: book_author item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT item_id_fk FOREIGN KEY (item_id) REFERENCES public.book(item_id) NOT VALID;


--
-- TOC entry 3241 (class 2606 OID 16690)
-- Name: documentary_documentary_producer producer_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary_documentary_producer
    ADD CONSTRAINT producer_id_fk FOREIGN KEY (producer_id) REFERENCES public.documentary_producer(producer_id);


--
-- TOC entry 3243 (class 2606 OID 16727)
-- Name: loan student_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT student_fk FOREIGN KEY (bronco_id) REFERENCES public.student(bronco_id);


-- Completed on 2023-05-11 00:35:28

--
-- PostgreSQL database dump complete
--

