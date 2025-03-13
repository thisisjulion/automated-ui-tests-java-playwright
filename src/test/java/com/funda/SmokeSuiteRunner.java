package com.funda;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@IncludeTags("smoke")
@SuiteDisplayName("Smoke Test Suite")
public class SmokeSuiteRunner {
}
