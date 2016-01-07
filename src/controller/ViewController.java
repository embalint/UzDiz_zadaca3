package controller;

import java.util.ArrayList;
import model.Model;
import registry.Registry;
import utils.Writer;
import view.Frame;
import view.FrameFactory;

public class ViewController extends Controller {

    private Frame inputFrame;

    private ArrayList<Frame> outputFrames = new ArrayList<>();

    public ViewController() {

        FrameFactory factory = (FrameFactory) this.get("frame.factory");

        inputFrame = factory.makeInputFrame();
        Registry.getInstance().set("frame.input", inputFrame);
        Writer.writerNextPosition = inputFrame.getWriterStartPosition();

        this.outputFrames.add(factory.makeFrame(1, (Model) this.get("model.structure")));
        //this.outputFrames.add(factory.makeFrame(2, (Model) this.get("model.info")));
        this.outputFrames.add(factory.makeFrame(2, (Model) this.get("model.structure")));

    }

    @Override
    public void work() {

        for (Frame f : outputFrames) {
            f.render();
        }

        inputFrame.render();

    }

}
