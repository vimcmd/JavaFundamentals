package com.github.vimcmd.javaFundamentals.p05_junit.sub07_events;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

// # 16 # listener registration

public class ScholarshipRunner extends BlockJUnit4ClassRunner {

    private ScholarshipRunListener runListener;

    public ScholarshipRunner(Class<?> klass) throws InitializationError {
        super(klass);
        runListener = new ScholarshipRunListener();
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(runListener);
        super.run(notifier);
    }
}
