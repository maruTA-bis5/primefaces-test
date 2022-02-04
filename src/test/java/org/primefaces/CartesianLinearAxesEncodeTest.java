package org.primefaces;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.render.RenderKit;

import org.junit.jupiter.api.Test;
import org.primefaces.component.charts.ChartRenderer;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;

class CartesianLinearAxesEncodeTest {

    @Test
    void testEncodeAxes() throws IOException {
        CartesianScales scales = new CartesianScales();
        CartesianLinearAxes axes = new CartesianLinearAxes();
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        axes.setTicks(ticks);
        scales.addXAxesData(axes);

        var renderer = new ChartRenderer() {
            // Make encodeScales public
            @Override
            protected void encodeScales(FacesContext context, String chartName, Object scales, boolean hasComma)
                    throws IOException {
                super.encodeScales(context, chartName, scales, hasComma);
            }
        };

        StringResponseWriter responseWriter = new StringResponseWriter();
        FacesContext context = new FacesContextMock() {
            @Override
            public ResponseWriter getResponseWriter() {
                return responseWriter;
            }
        };
        renderer.encodeScales(context, "chartName", scales, false);

        // "scales":{"x":{"offset":false,"stacked":false,"ticks":{"autoSkip":true,"mirror":false,"beginAtZero":true}}}
        fail(responseWriter.getString());
    }
}

class StringResponseWriter extends ResponseWriter {

    private final StringWriter writer = new StringWriter();

    public String getString() {
        return writer.toString();
    }

    @Override
    public void flush() throws IOException {
        writer.flush();
    }

    @Override
    public String getContentType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public String getCharacterEncoding() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public void startDocument() throws IOException {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException();
    }

    @Override
    public void endDocument() throws IOException {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException();
    }

    @Override
    public void startElement(String name, UIComponent component) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

    @Override
    public void endElement(String name) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

    @Override
    public void writeAttribute(String name, Object value, String property) throws IOException {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException();
    }

    @Override
    public void writeURIAttribute(String name, Object value, String property) throws IOException {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException();
    }

    @Override
    public void writeComment(Object comment) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();

    }

    @Override
    public void writeText(Object text, String property) throws IOException {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException();
    }

    @Override
    public void writeText(char[] text, int off, int len) throws IOException {
        writer.write(text, off, len);
    }

    @Override
    public ResponseWriter cloneWithWriter(Writer writer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        writer.write(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

}

class FacesContextMock extends FacesContext {

    @Override
    public Application getApplication() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<String> getClientIdsWithMessages() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExternalContext getExternalContext() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Severity getMaximumSeverity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<FacesMessage> getMessages() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<FacesMessage> getMessages(String clientId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RenderKit getRenderKit() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getRenderResponse() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getResponseComplete() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ResponseStream getResponseStream() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setResponseStream(ResponseStream responseStream) {
        // TODO Auto-generated method stub

    }

    @Override
    public ResponseWriter getResponseWriter() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setResponseWriter(ResponseWriter responseWriter) {
        // TODO Auto-generated method stub

    }

    @Override
    public UIViewRoot getViewRoot() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setViewRoot(UIViewRoot root) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addMessage(String clientId, FacesMessage message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void release() {
        // TODO Auto-generated method stub

    }

    @Override
    public void renderResponse() {
        // TODO Auto-generated method stub

    }

    @Override
    public void responseComplete() {
        // TODO Auto-generated method stub

    }

}
