package com.dongql.mybatis.tenant.parser;

import com.dongql.mybatis.tenant.cache.ParsedSQL;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

/**
 * left|right|cross JOIN语句
 * Created by dongqilin on 2017/7/11.
 */
public class JoinParser extends SelectParser {

    public JoinParser(ParsedSQL<String> parsedSQL) {
        super(parsedSQL.getSql());
        this.parsedSQL = parsedSQL;
        this.pattern = Pattern.compile("(left|right|cross)? join " + TABLE_NAME + " " + TABLE_NAME + "[, ]+", CASE_INSENSITIVE);
    }

    public ParsedSQL<String> parse() {
        return parse(2, 3);
    }

}