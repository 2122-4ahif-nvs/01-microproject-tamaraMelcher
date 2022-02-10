package at.htl.control;

import at.htl.RouteReply;
import at.htl.RouteRequest;
import at.htl.RouteWithID;
import at.htl.control.RouteRepository;
import at.htl.entity.Route;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;

@GrpcService
public class RouteService implements RouteWithID {

    @Inject
    RouteRepository routeRepository;

    @Override
    @Blocking
    public Uni<RouteReply> getRoute(RouteRequest request) {
        Route route = routeRepository.findById((long)request.getId());
        return Uni.createFrom().item(() -> {
                    return RouteReply.newBuilder()
                            .setName(route.name)
                            .setColor(route.color)
                            .build();
                }
        );
    }
}
