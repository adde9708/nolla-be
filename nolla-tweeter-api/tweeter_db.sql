PGDMP     9    /                z         
   tweeter_db    14.2    14.2 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394 
   tweeter_db    DATABASE     g   CREATE DATABASE tweeter_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_Sweden.1252';
    DROP DATABASE tweeter_db;
                postgres    false            �            1259    16396    tweets    TABLE       CREATE TABLE public.tweets (
    twt_id integer NOT NULL,
    usr_id integer NOT NULL,
    created_twt timestamp without time zone DEFAULT now(),
    updated_twt timestamp without time zone DEFAULT now(),
    likes_twt integer DEFAULT 0,
    content_twt character varying(200)
);
    DROP TABLE public.tweets;
       public         heap    postgres    false            �            1259    16395    tweets_twt_id_seq    SEQUENCE     �   ALTER TABLE public.tweets ALTER COLUMN twt_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tweets_twt_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210            �          0    16396    tweets 
   TABLE DATA           b   COPY public.tweets (twt_id, usr_id, created_twt, updated_twt, likes_twt, content_twt) FROM stdin;
    public          postgres    false    210   4	       �           0    0    tweets_twt_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.tweets_twt_id_seq', 45, true);
          public          postgres    false    209            `           2606    16403    tweets tweets_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.tweets
    ADD CONSTRAINT tweets_pkey PRIMARY KEY (twt_id);
 <   ALTER TABLE ONLY public.tweets DROP CONSTRAINT tweets_pkey;
       public            postgres    false    210            �   �  x�}��n�0E��W����_�?P-�e6j��.�����؉$�a�8�ѐ���4D_��LJ��Fｸ����0m_��������3�N���w�;sc^��hƓ9���h����޶�л;t.ژ\\C��w����5�T0k�\$5͍�����p|�P�8�����h�v��?���a|���0���_[���c��4/���4��|�~>���I��HR�<����eXC3O*z�X�Q���G��;�݇w[@3�L䧧:mΒI������"��O����������䄗��.
0YL)�P����N-|e�/��ij( �Ej(�@"�TQ�� Y����,�-E�JC����VI��Ҩp�ʂU/��P�XCY�J�W�\z�W��$^z	�U�I]��Ai�(6�(��S��,�H��B�NsZAY��D�A�I�I��,�H���H�I��,�H�XI�CxCg���A���w��$j/�K��,($���"��8Cy{o��EN�gRW\
�A�4��j�N�4��\5C��
��~�,�h����EQ��iGԓ�R1C����Bd�+Ah���n�Tyw���Bl��(ؔ�qY�]�jy�`�P6�,�_E��8X�|��Se��'�o&�P�Z��p� �B��\�=N�db�k�:��-%8�<Z��-�X�\�_
�;�4�^���ުhom۶���fJ     